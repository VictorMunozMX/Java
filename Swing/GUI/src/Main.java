import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        JFrame frame = new JFrame("Mi Formulario");
        frame.setContentPane(new VentanaPrincipal().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.pack();
        frame.setVisible(true);

    }
}