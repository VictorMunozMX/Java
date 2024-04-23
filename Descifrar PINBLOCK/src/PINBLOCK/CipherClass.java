package PINBLOCK;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CipherClass 
{
    private String desCipherTDESECB(String llave, String data)
    {
        byte[] key = HexStringToByteArray(llave + llave.substring(0, 16));
        byte[] input = HexStringToByteArray(data);
    	SecretKeySpec keySpec = new SecretKeySpec(key, 0, 24, "TripleDES");
	try
	{
            Cipher nCipher=Cipher.getInstance("TripleDES/ECB/NoPadding");
            nCipher.init( Cipher.DECRYPT_MODE, keySpec );
            return ByteArrayToHexString(nCipher.doFinal(input));
	}
	catch(Exception e)
	{
            System.out.println(e.getMessage());
	}
	return "";
    }
    
    private String cipherTDESECB(String llave, String data)
    {
        byte[] key = HexStringToByteArray(llave + llave.substring(0, 16));
        byte[] input = HexStringToByteArray(data);
        SecretKeySpec keySpec = new SecretKeySpec(key, 0, 24, "TripleDES");
	try
	{
            Cipher nCipher=Cipher.getInstance("TripleDES");
            nCipher.init( Cipher.ENCRYPT_MODE, keySpec );
            return ByteArrayToHexString(nCipher.doFinal(input)).toUpperCase();
	}
	catch(Exception e)
	{
            System.out.println(e.getMessage());
	}
	return "";
    }
		
    private byte[] HexStringToByteArray(String s) 
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
	
    private String ByteArrayToHexString(byte[] data) 
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
    
    private String xor(String A, String B)
    {
        byte[] Abyte = HexStringToByteArray(A);
        byte[] Bbyte = HexStringToByteArray(B);
        for (int i = 0; i < Abyte.length; i++) 
        {
            Bbyte[i] ^= Abyte[i];
        }
        return ByteArrayToHexString(Bbyte);
    }
    
    public String pin (String Llave, String PinBlock, String PAN12Dig, String PAN06)
    {       
        String clearPinBlockPadded = padRight(desCipherTDESECB(Llave,PinBlock), 32, '0');
        String panPadded = padRight(padLeft(PAN12Dig, 16, '0'), 32, '0');
        String pinClear = xor(clearPinBlockPadded, panPadded);        
        //String paso =  pinClear.substring(2, 6);
        String paso;
        //System.out.println("MMMMMMM" +  PAN06 + "-----");
        if  (PAN06.equals("523595") || PAN06.equals("539978"))
            {
                paso = pinClear.substring(0, 4);
            }
        else
        {
               paso =  pinClear.substring(2, 6);
        }
        return paso;
    }
    
    public String pinBlockTGS(String llave, String pin)
    {
        return cipherTDESECB(llave, "24" + pin + "FFFFFFFFFF").substring(0, 16);
    }
        
    public String padRight(String s, int n, char caracter) 
    {
         return String.format("%1$-" + n + "s", s).replace(' ', caracter);
    }

    private String padLeft(String s, int n, char caracter) 
    {
        return String.format("%1$" + n + "s", s).replace(' ', caracter);  
    }
    
}