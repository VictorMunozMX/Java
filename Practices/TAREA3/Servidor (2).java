import java.io.* ;
import java.net.* ;
class Servidor {
   static final int PUERTO=5000;
   public Servidor() {
     try {
			ServerSocket skServidor = new ServerSocket(PUERTO);
			System.out.println("Escucho el puerto " + PUERTO );
	
		for ( int numCli = 0; numCli < 3; numCli++ ) {
			double suma=0,lnnum=0, datos=0;	
			String numero, sfinal;
			
			Socket skCliente = skServidor.accept(); // Crea objeto				
			System.out.println("Sirvo al cliente " + numCli);
			DataOutputStream flujo= new DataOutputStream(skCliente.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(skCliente.getInputStream());       				
			ObjectOutputStream salida = new ObjectOutputStream(skCliente.getOutputStream());   	 				

			do{
				try{				
					numero = (String) entrada.readObject();   				    														
					lnnum  = Double.parseDouble(numero);						
					suma  += lnnum;					    
					datos +=1;					
				}catch(Exception e) {
					System.out.println(e);
				}
			}while(datos!=2);						
			sfinal = String.valueOf(suma);		    
			///System.out.println("La suma es: " + sfinal);													   		
					
			flujo.writeUTF("Hola cliente " + numCli);
			salida.writeObject("La suma de tus valores es: " + sfinal);
			
			skCliente.close();
     	}
     	System.out.println("Demasiados clientes por hoy");
     	} catch( Exception e ) {
		System.out.println( e.getMessage() );
     	}
   	}
   	public static void main( String[] arg ) throws IOException {
  	new Servidor();
   	}
}
