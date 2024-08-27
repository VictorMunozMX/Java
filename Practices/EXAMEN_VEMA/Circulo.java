import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Circulo{	
	private JFrame f;
	private JButton b1,b2;	
	private JLabel ly,ln,lr,r;
	private JTextField ty,tn;
	
    public Circulo(){
		f  = new JFrame("Area de Circulo");		
		ly = new JLabel (" Radio: ");		
		ln = new JLabel (" Area: ");		
		ty = new JTextField ("");				
		tn = new JTextField ("");		
		lr = new JLabel (" El perimetro es: ");		
		r  = new JLabel ("");		
		
		b1 = new JButton (" Area");		
		// Escucha para B2
		b1.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e){
				accionb1(e);
			}
		});		
		
		b2 = new JButton (" Perimetro");						
		// Escucha para B2
		b2.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e){
				accionb2(e);
			}
		});								
		}								
		
    public void Ordenar(){
    	f.getContentPane().setLayout(new GridLayout(4,2));
    	f.getContentPane().add(ly);
		f.getContentPane().add(ty);    	    	
    	f.getContentPane().add(ln);    	
    	f.getContentPane().add(tn);    	
    	f.getContentPane().add(b1);
    	f.getContentPane().add(b2);
    	f.getContentPane().add(lr);    	
    	f.getContentPane().add(r);    	
    	f.setVisible(true);
    	f.pack();    	    
    }
    //Manejo de Evento Boton1
    private void accionb1(java.awt.event.ActionEvent e){
		double tmp1, a;
		tmp1 = Double.parseDouble(ty.getText());		
		Calculo x = new Calculo(tmp1);
		a = x.area();
		tn.setText(String.valueOf(a));		
    }
    //Manejo de Evento Boton2
    private void accionb2(java.awt.event.ActionEvent e){
    	double  tmp1, a;
		tmp1 = Double.parseDouble(ty.getText());		
		Calculo x = new Calculo(tmp1);
		a = x.perimetro();
		r.setText(String.valueOf(a));		
    }
}
