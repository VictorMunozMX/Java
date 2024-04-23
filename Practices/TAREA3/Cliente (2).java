import java.io.*;
import java.net.*;
class Cliente {
  static final String host = "localhost";
  static final int puerto=5000;
  public Cliente( ) {
    try{
     Socket skCliente = new Socket(host,puerto);    
     DataInputStream flujo = new DataInputStream(skCliente.getInputStream());
     
     String  s1,s2,cadena;            
	 ObjectOutputStream salida = new ObjectOutputStream(skCliente.getOutputStream());   	 
	 ObjectInputStream entrada = new ObjectInputStream(skCliente.getInputStream());       					 	
     BufferedReader b = new BufferedReader(new InputStreamReader(System.in));        

	 ///Pide valores aleatorios y los envia al Servidor
     System.out.println("\nFavor de introducir el numero 1: ");
     s1 = b.readLine();     	 	      	
	 salida.flush();
	 salida.writeObject(s1);        	      	
     System.out.println("\nFavor de introducir el numero 2: ");
     s2 = b.readLine();             	
     salida.flush();
	 salida.writeObject(s2);                      	 	 	
     	
     System.out.println(flujo.readUTF());     
     
     ///En teoria recibe el mensaje y lo muestra
     String valor = (String) entrada.readObject();
     System.out.println(valor);
     
     skCliente.close();
   } catch( Exception e ) {
     System.out.println( e.getMessage() );
   }
 }
 public static void main( String[] arg ) {
     new Cliente();
 }
}
