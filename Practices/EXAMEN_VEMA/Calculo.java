public class Calculo{	
  	public double lm,a;  	
   	public Calculo(double lm){
   		this.lm=lm;   		   		
   	}    	
   		
	public double area(){  		
   		return(3.14*(lm*lm));
	}    		    	    		    		
		
	public double perimetro(){		
  		return(3.14*(2*lm));  		
	}
}