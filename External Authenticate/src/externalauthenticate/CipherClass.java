package externalauthenticate;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import externalauthenticate.CanalTarjeta;
import javax.crypto.spec.*;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.SecretKey;


public class CipherClass 
{
	static public final String constCMACsk = "0101";
	static public final String constSENCsk = "0182";
	static final String constPADD = "000000000000000000000000";
	static final byte[] constIV  = HexStringToByteArray("0000000000000000");
	
	public String cipherTDESECB(byte[] key, byte[] data)
	{
		SecretKeySpec keySpec = new SecretKeySpec(key,0, 24,"TripleDES");
		try
		{
			Cipher nCipher=Cipher.getInstance("TripleDES");
			nCipher.init( Cipher.ENCRYPT_MODE, keySpec );
		
			return arrayToHex(nCipher.doFinal(data));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	public String cipherTDESCBC(byte[] key, byte[] data, byte[] iV)
	{
		SecretKeySpec keySpec = new SecretKeySpec(key,0, 24,"TripleDES");
		IvParameterSpec iVSpec = new IvParameterSpec(iV);
		try
		{
			Cipher nCipher=Cipher.getInstance("DESede/CBC/NoPadding");
			nCipher.init( Cipher.ENCRYPT_MODE, keySpec, iVSpec );
		
			return arrayToHex(nCipher.doFinal(data));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	public String sessionKey(String staticKey, String initializeUpdateResponse, String constSessionK)
	{
		String sequenceCounter = initializeUpdateResponse.substring(24, 28);
		String derivationData = constSessionK + sequenceCounter + constPADD;
		//System.out.println("Derivation Data Session Key: " + derivationData);
		String sessionKey = cipherTDESCBC(HexStringToByteArray(staticKey), HexStringToByteArray(derivationData), constIV);
                System.out.println("Session Key: " + sessionKey.toUpperCase());
		return sessionKey + sessionKey.substring(0, 16);
	}
        

	//caso 1: ENC  caso 2: MAC caso 3: DEK
        //Metodo 1:Visa2 2:CPS 3:Sin Derivacion
	public String staticKey(String KEY, String updateInitializeResponse, int caso, int metodo)
	{
            String keyName = "";
		String cardManagerID = updateInitializeResponse.substring(0, 4);
		String icSN = updateInitializeResponse.substring(8, 16);
		String keyData = updateInitializeResponse.substring(8, 20);
                System.out.println("KeyData: " + keyData);
		String keyDeriv = "";
		if (metodo == 1)
		{
			switch (caso)
			{
				case 1: keyDeriv = cardManagerID + icSN + "F001" + cardManagerID + icSN + "0F01";
                                keyName = "ENC Key Derivated: ";
				break;
				case 2: keyDeriv = cardManagerID + icSN + "F002" + cardManagerID + icSN + "0F02";
				keyName = "MAC Key Derivated: ";
                                break;
				case 3: keyDeriv = cardManagerID + icSN + "F003" + cardManagerID + icSN + "0F03";
				keyName = "DEK Key Derivated: ";
                                break;
			}
		}
		if (metodo == 2)
		{
			switch (caso)
			{
				case 1: keyDeriv = keyData + "F001" + keyData + "0F01";
				keyName = "ENC Key Derivated: ";
                                break;
				case 2: keyDeriv = keyData + "F002" + keyData + "0F02";
				keyName = "MAC Key Derivated: ";
                                break;
				case 3: keyDeriv = keyData + "F003" + keyData + "0F03";
				keyName = "DEK Key Derivated: ";
                                break;
			}
		}
                if (metodo == 3)
                {
                    System.out.println(keyName + KEY.substring(0, 32).toUpperCase());
                    return KEY;
                }
		//System.out.println("KeyDerivData: " + keyDeriv);
		String keyStaticLeft = cipherTDESECB(HexStringToByteArray(KEY), HexStringToByteArray(keyDeriv.substring(0, 16)));
		String keyStaticRight = cipherTDESECB(HexStringToByteArray(KEY), HexStringToByteArray(keyDeriv.substring(16, 32)));
                System.out.println(keyName + keyStaticLeft.substring(0, 16).toUpperCase() + keyStaticRight.substring(0, 16).toUpperCase());
		return keyStaticLeft.substring(0, 16) + keyStaticRight.substring(0, 16) + keyStaticLeft.substring(0, 16);
	}
	
	public String initializeUpdateAPDU(String hostChallenge)
	{		
		return "8050000008" + hostChallenge;
	}
	
	public String externalAuthenticateAPDU(String SMACKey, String hostCrypto, boolean secure)
	{
		String exAuthAPDU = "";
		if (!secure)
		   exAuthAPDU = "8482000010";
		else
			exAuthAPDU = "8482010010";
		String derivationData = exAuthAPDU + hostCrypto.substring(32, 48) + "800000";
		System.out.println("Input Data to MAC: " + derivationData.toUpperCase());
		String derivationDataLeft = derivationData.substring(0, 16);
		String derivationDataRight = derivationData.substring(16, 32);
		String iCV1 = cipherTDESCBC(HexStringToByteArray(SMACKey.substring(0, 16)+ SMACKey.substring(0, 16) + SMACKey.substring(0, 16)), HexStringToByteArray(derivationDataLeft), constIV);
		//System.out.println("iCV1: " + iCV1.toUpperCase());
		String MAC = cipherTDESCBC(HexStringToByteArray(SMACKey), HexStringToByteArray(derivationDataRight), HexStringToByteArray(iCV1));
		//System.out.println("MAC: " + MAC);
		exAuthAPDU = exAuthAPDU + hostCrypto.substring(32, 48) + MAC;
                System.out.println("Auth APDU: " + exAuthAPDU.toUpperCase());
		return exAuthAPDU;
	}
	
	public String calculateCardCryptogram(String SENCKey, String initializeUpdateR, String hostChallenge)
	{
		String sequenceCounter = initializeUpdateR.substring(24, 28);
		String cardChallenge = initializeUpdateR.substring(28,40);
		//String inputData = sequenceCounter + cardChallenge + hostChallenge + "8000000000000000";
		String inputData = hostChallenge + sequenceCounter + cardChallenge + "8000000000000000";
		//System.out.println("inputData card Cryptogram: " + inputData);
		String hostCryptogram = cipherTDESCBC(HexStringToByteArray(SENCKey), HexStringToByteArray(inputData),constIV);
		return hostCryptogram;
	}
	
	public String calculateHostCryptogram(String SENCKey, String initializeUpdateR, String hostChallenge)
	{
		String sequenceCounter = initializeUpdateR.substring(24, 28);
		String cardChallenge = initializeUpdateR.substring(28,40);
		String inputData = sequenceCounter + cardChallenge + hostChallenge + "8000000000000000";
                System.out.println("Input Data to HostCryptogram: " + inputData.toUpperCase());
		String hostCryptogram = cipherTDESCBC(HexStringToByteArray(SENCKey), HexStringToByteArray(inputData),constIV);
                return hostCryptogram;
	}
			
	public String hostChallenge()
	{
		try
		{
			KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
			SecretKey key = keyGen.generateKey();
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			DESedeKeySpec keySpec = (DESedeKeySpec) keyFactory.getKeySpec(key, DESedeKeySpec.class);
			return arrayToHex(keySpec.getKey()).substring(0, 16);
		}		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	public static  byte[] HexStringToByteArray(String s) 
	{     
		Integer b = 0;
		byte data[] = new byte[s.length()/2];     
		for(int i=0;i < s.length();i+=2) 
		{         
			b = (Integer.decode("0x"+s.charAt(i)+s.charAt(i+1)));				
			data[i/2] = b.byteValue();			
		}     
		return data; 
	}
	
	public static String arrayToHex(byte[] data) 
	{
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) 
        {
            String bs = Integer.toHexString(data[i] & 0xFF);
            if (bs.length() == 1) 
            {
                sb.append(0);
            }
            sb.append(bs);
        }
        return sb.toString();
    }
}