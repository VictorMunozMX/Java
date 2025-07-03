import javax.swing.*;

public class VentanaPrincipal {
    private JButton miBoton;
    public JPanel panel1;
    private JLabel etiquetaTexto;

    public VentanaPrincipal() {
        miBoton.addActionListener(e -> {
            etiquetaTexto.setText("¡Hola desde Swing!");
        });
    }

}
