public class Consume extends Thread {
	private entero valorp;
	public Consume(entero valor){
		super("Consumidor entero");
		valorp = valor;
	}
	public void run()
	{
		int value, sum=0;
		do{
			try{
				Thread.sleep((int) (Math.random()*3000));				
			}
			catch(InterruptedException e){
				System.out.println(e.toString());
			}
			value =valorp.getIntCompartido();
			sum += value;
		} while (value != 10);
		System.out.println(getName()+ " Suma de los enteros: " + sum + "\nFinalizado " + getName());
	}
}
	