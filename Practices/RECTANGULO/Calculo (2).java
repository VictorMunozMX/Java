public class Calculo{
	
  	public double lm,ln;
   	public Calculo(double lm,double ln){
   		this.lm=lm;
   		this.ln=ln;
   	}    	
	public double area(){
  		
   		return(lm*ln);
	}    		    	    		    		
	public double perimetro(){
		double a;
  		a = 2*(lm+ln);
  		return(a);
	}
}