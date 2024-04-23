import java.awt.*;
import javax.swing.*;
public class AccionBotones{	
	private JFrame f;
	private JButton b1,b2;
	private JLabel l;
	
    public AccionBotones() {
		f = new JFrame("Acciones con Botones");
		
		b1= new JButton (" Boton 1 ");
		// Escucha para B1
		b1.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e){
				accionb1(e);
			}
		});
		
		b2= new JButton (" Boton 2 ");	
		// Escucha para B2
		b2.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e){
				accionb2(e);
			}
		});			
			
		// Etiqueta
		l = new JLabel (" Fue: ");
    }
    public void Ordenar(){
    	f.getContentPane().setLayout(new GridLayout(2,2));
    	f.getContentPane().add(b1);
    	f.getContentPane().add(b2);
    	f.getContentPane().add(l);
    	f.setVisible(true);
    	f.pack();    	    
    }
    //Manejo de Evento Boton1
    private void accionb1(java.awt.event.ActionEvent e){
    	l.setText(" Ejecuto B1");
    }
    //Manejo de Evento Boton2
    private void accionb2(java.awt.event.ActionEvent e){
    	l.setText(" Ejecuto B2");
    }
}