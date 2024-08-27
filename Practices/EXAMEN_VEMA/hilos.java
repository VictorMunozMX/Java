public class hilos extends Thread {
    private int dormir;
    int valor = 0;
    String mostrar;
        
    public hilos(String nombre) {
    	super(nombre);         
        dormir = (int)( Math.random()*5000); 
        System.out.println("Ejecutando Hilo " + getName() + ";" + 				dormir ); //constructor
        	for (int i=1; i<6; i++){
          		valor = valor +1;
            	String.valueOf(valor);
            	System.out.println("Hilo numero "+ getName()+ "  Cuenta = "+ valor);
          }
    }
          
    public void run()
    {    
    	try {
			System.out.println( getName() + " ir a dormir:" );                
        	Thread.sleep(dormir);
    	}catch (InterruptedException e) {
        	System.out.println( e.toString() );
        }         
    	System.err.println( getName() + " dormido " );
    }   
    
    public static void main(String[] args) {
         hilos ln1, ln2, ln3, ln4, ln5;                 
         ln1 = new hilos( "1" );
         ln1.start();
         ln2 = new hilos( "2" );
         ln2.start();
         ln3 = new hilos( "3" );
         ln3.start();
         ln4 = new hilos( "4" );
         ln4.start();
         ln5 = new hilos( "5" );
         ln5.start();
         System.out.println( "Finalizo la Cargo de hilos " );    
         }                        
         
}
