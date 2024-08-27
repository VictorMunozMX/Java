public class ProducirConsumir {
    public static void main(String [] args){
    	entero numero = new entero();
    	
    	Produce prod = new Produce(numero);
    	Consume cons = new Consume(numero);
    	prod.start();
    	cons.start();    	
    }
}