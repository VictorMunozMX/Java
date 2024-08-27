package externalauthenticate;
import externalauthenticate.CanalTarjeta;
import externalauthenticate.CipherClass;
import java.io.*;

public class ExternalAuthenticate 
{
	//static String nombreArchivo = "";

	public static void main(String[] args) 
	{
	    //nombreArchivo = leerDato("Coloca el nombre del archivo de seriales:");
            //escribeArchivo(nombreArchivo,"Hola dime donde te creas");
            procesoPrincipal();
        }
	static boolean Auth(CanalTarjeta obj, CipherClass objCipher, boolean secure)
	{
//		String hostChallenge = objCipher.hostChallenge();
		String hostChallenge = "B8D4F6937A57428A";
		//System.out.println("Initialize update: " + objCipher.initializeUpdateAPDU(hostChallenge));
//		String initializeR = obj.envioComando(objCipher.initializeUpdateAPDU(hostChallenge), obj.canal);
		String initializeR = "00000000000000000000FF020002D9857D532F04388D41C911FDFE28";
		System.out.println("Initialize Response: " + initializeR.toUpperCase());
		//System.out.println("Serial: " + iCSN(initializeR));
		String staticKey = "404142434445464748494A4B4C4D4E4F4041424344454647";
//		String staticKey = "DCDAB6BF3D2FEA20D06EA107F7E90E98DCDAB6BF3D2FEA20";
//		String staticKey = "47454D5850524553534F53414D504C4547454D5850524553";
//                caso 1: ENC  caso 2: MAC caso 3: DEK
//                Metodo 1:Visa2 2:CPS 3:Sin Derivacion
		String staticKeyENC = objCipher.staticKey(staticKey, initializeR, 1, 2);
		String staticKeyMAC = objCipher.staticKey(staticKey, initializeR, 2, 2);
		String staticKeyDEK = objCipher.staticKey(staticKey, initializeR, 3, 2);
		String sessionKeyENC = objCipher.sessionKey(staticKey, initializeR, CipherClass.constSENCsk);
		String sessionKeyMAC = objCipher.sessionKey(staticKey, initializeR, CipherClass.constCMACsk);
		//String sessionKeyDEK = objCipher.sessionKey(staticKeyMAC, initializeR, CipherClass.constCMACsk);
		//String cardCrypto = objCipher.calculateCardCryptogram(sessionENCKey, initializeR, hostChallenge);
		String hostCrypto = objCipher.calculateHostCryptogram(sessionKeyENC, initializeR, hostChallenge);
		String exauthApdu = objCipher.externalAuthenticateAPDU(sessionKeyMAC, hostCrypto, secure);
//		System.out.println(obj.envioComando(exauthApdu, obj.canal));
		return true;
	}
	
	static boolean ejecutaScript(CanalTarjeta obj, String nombreScript)
	{
	      File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      String cad = "";
	      String respuesta = "";
	      try
	      {
	    	  archivo = new File (directorioActual(nombreScript));
	          fr = new FileReader (archivo);
	          br = new BufferedReader(fr);
	          while((cad = br.readLine()) != null)
	          {
	        	  if(cad.startsWith("80") || cad.startsWith("00A") || cad.startsWith("84"))
	        	  {
	        		  System.out.println(cad);
	        		  respuesta = obj.envioComando(cad, obj.canal);
	        		  System.out.println(respuesta.toUpperCase());
	        		  if (!respuesta.equals("00") && !statusWord(respuesta))
	        			  return false;
	        	  }
	          }
	          return true;
	      }
	      catch(Exception e)
	      {
	    	  System.out.println(e.getMessage());
	      }
	      return true;
	}
	
	static String directorioActual(String nombreApplet)
	{
		 File miDir = new File (".");
		 String directorio = "";
	     try 
	     {
	       directorio = miDir.getCanonicalPath() + "\\" + nombreApplet;
	     }
	     catch(Exception e) 
	     {
	       e.printStackTrace();
	     }
		return directorio;
	}
	
	static String leerDato(String pregunta)
	{
		String dato = "";		 
	    System.out.print(pregunta); 
	    try 
	    { 
	    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));   
	    	dato = entrada.readLine(); 
	    }
	    catch (IOException e) 
	    {
	    	System.out.println( e.getMessage());
	    } 
		return dato;
	}
	
	static String iCSN(String initializeResponse)
	{
		return initializeResponse.substring(8, 16).toUpperCase();
		
	}
	
	static void escribeArchivo(String archivo, String cad)
	{
		try
		{
			String ruta = directorioActual(archivo);
			BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta, true));
			escritor.write(cad);
			escritor.newLine();
			escritor.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}		
	}
	
	static boolean procesoPrincipal()
	{
		CanalTarjeta obj = new CanalTarjeta();
		CipherClass objCipher = new CipherClass();
//		ejecutaScript(obj, "SelectISDN.log");
		if(!Auth(obj, objCipher, false))
			return false;
		//if(!ejecutaScript(obj, "DeleteSamApp.log"))
			//return false;
		/*if(!ejecutaScript(obj, "LoadSamApplet.log"))
			return false;
		if(!ejecutaScript(obj, "SelectSamApp.log"))
			return false;
		if(!Auth(obj, objCipher, false))
			return false;
		if(!ejecutaScript(obj, "PutKeysPROD_TEST.log"))
			return false;*/
		//if(!Auth(obj, objCipher, true))
			//return false;
		//if(!ejecutaScript(obj, "ModeSecured.log"))
			//return false;
		return true;
	}
	
	static boolean statusWord(String response)
	{
		if(response.contains("SW=9000"))
			return true;
		else
			return false;
	}
	
	static void initializeResponse(String archivo, String pan)
	{
		CanalTarjeta obj = new CanalTarjeta();
		CipherClass objCipher = new CipherClass();
		String hostChallenge = objCipher.hostChallenge();
		String initializeR = obj.envioComando(objCipher.initializeUpdateAPDU(hostChallenge), obj.canal).toUpperCase();
		System.out.println(initializeR);
		escribeArchivo(archivo, pan + "@" + initializeR);
	}

}
