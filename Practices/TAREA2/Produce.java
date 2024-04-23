public class Produce extends Thread {
	private entero valorp;
	public Produce(entero valor){
		super("Produce entero");
		valorp = valor;
	}
	public void run()
	{
		for (int count = 1; count <= 10; count++){
			try {
				Thread.sleep((int)(Math.random()*3000));
			}
				catch(InterruptedException e){
					System.out.println(e.toString());
				}
				valorp.setIntCompartido(count);
			}
			System.out.println(getName() + " Termino la produccion de valores" + "\nFinalizado " + getName());
		}
}
	