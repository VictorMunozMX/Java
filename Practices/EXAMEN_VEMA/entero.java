public class entero{
	private int Intcompartido= -1;
	public void setIntCompartido(int value){
		System.out.println(Thread.currentThread().getName() + ", Genero el Entero " + value);
		Intcompartido= value;		
	}
	public int getIntCompartido()
	{
		System.out.println(Thread.currentThread().getName() + ", Recupera el valor " + Intcompartido);
		return Intcompartido;
	}	
}