package PINBLOCK;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class DescifradoPB 
{
    CipherClass CipherObj = new CipherClass();    
    String PosPan = "";
    String PosPinBlock = "";
    int longitud;
    String rutaArchivo = "";
    String Llave = "";
    Boolean generarArchivo;
    List<String> listaPAN = new ArrayList<>();
    List<String> listaPinBlock = new ArrayList<>();

    
    public DescifradoPB(String rutaArchivo, String PosPan, String PosPinBlock, String longitud, String Llave, Boolean generarArchivo)
    {
        this.rutaArchivo = rutaArchivo;
        this.PosPan = PosPan;
        this.PosPinBlock = PosPinBlock;
        this.Llave = Llave;
        this.generarArchivo = generarArchivo;
        this.longitud = Integer.parseInt(longitud);
    }

    public boolean procesarArchivoDePinBlock()
    {
        File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
	String cad = "";
        String pin = "";
        String newPinBlock = "";
        List<String> registros = new ArrayList<>();
        try
	{
            int posPan = Integer.parseInt(PosPan) - 1;
            int posPINB = Integer.parseInt(PosPinBlock) - 1;
            archivo = new File (rutaArchivo);
	    fr = new FileReader (archivo);
	    br = new BufferedReader(fr);
	    while((cad = br.readLine()) != null)
	    {
                //vema prueba
                int axa = cad.trim().length();
                if (cad.trim().length() < longitud)
                    continue;
                if (cad.substring(posPINB, posPINB + 16).trim().equals(""))
                {
                    pin="    ";
                    newPinBlock = "                ";
                }
                else
                {
                    //pin = CipherObj.pin(Llave, cad.substring(posPINB, posPINB + 16), cad.substring(posPan, posPan + 12));
                    /*String  aa = cad.substring(82, 88);
                    String  aa1 = Llave;
                    String  aa2 = cad.substring(posPINB, posPINB + 16);
                    String  aa3 = cad.substring(posPan, posPan + 12);*/
                    pin = CipherObj.pin(Llave, cad.substring(posPINB, posPINB + 16), cad.substring(posPan, posPan + 12), cad.substring(82, 88));
                    newPinBlock = CipherObj.pinBlockTGS(Llave, pin);
                    if (!pin.matches("^[0-9]+$"))
                    {
                        JOptionPane.showMessageDialog(null, "pin descifrado no tiene formato numerico", "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
                listaPAN.add(cad.substring(posPan, posPan + 12));
                listaPinBlock.add(pin + " " + newPinBlock);
                if (!generarArchivo)
                    registros.add(cad + pin + " " + newPinBlock);
            }
            if (!generarArchivo)
               escribeArchivo(rutaArchivo + ".pin", registros);
            return true;
	}
	catch(Exception e)
	{
            JOptionPane.showMessageDialog(null, e.getMessage() + ":Probablemente el archivo no tiene extensión, colocarle una", "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
            return false;
	}        
    }
    
    public Boolean agregarPBToCRD(String rutaArchivo2, String PosPan)
    {
//        File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
	String cad = "";
        String PAN = "";
        int pos, opcion;
        List<String> registros = new ArrayList<>();
        try
	{
            int posPan = Integer.parseInt(PosPan) - 1;
//            archivo = new File (rutaArchivo);
	    fr = new FileReader (rutaArchivo2);
	    br = new BufferedReader(fr);            
	    while((cad = br.readLine()) != null)
	    {
                PAN = cad.substring(posPan, posPan + 12);
                if (!listaPAN.contains(PAN))
                {
                    opcion = JOptionPane.showConfirmDialog(null, "No se encontro PAN: " + PAN + " en registro, desea continuar?", "App Message", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (opcion == 0)
                        continue;
                    else
                        return false;
                }
                pos = listaPAN.indexOf(PAN);
                registros.add(cad + listaPinBlock.get(pos));                
            }
            escribeArchivo(rutaArchivo2.substring(0, rutaArchivo2.lastIndexOf(".")).concat(".tmp"), registros);
            return true;
	}
	catch(Exception e)
	{
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
            return false;
	}        
    }
    
    
    private void escribeArchivo(String archivo, List<String> registros)
    {
	try
	{
	    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
            for(String registro:registros)
            {
                escritor.write(registro);
                escritor.newLine();
            }
            escritor.close();
	}
	catch(Exception e)
	{
            System.out.println(e.getMessage());
	}		
    }
    
    public static String rutaArchivo()
    {
        JFileChooser cuadroDialogo = new JFileChooser("C:\\Users\\vbejarano\\Documents\\vbejarano\\Implementaciones");
//        cuadroDialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = cuadroDialogo.showOpenDialog(null);
        File archivo = cuadroDialogo.getSelectedFile();
        if(seleccion == JFileChooser.APPROVE_OPTION)
        {
            return archivo.getAbsolutePath(); 
        }        
        return "";
    }
    
    public static String[] elementosConf(String rutaArchivo)
    {
        String[] elementos = null;
        File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
        String cad = "";
        try
	{
            archivo = new File (rutaArchivo);
	    fr = new FileReader (archivo);
	    br = new BufferedReader(fr);
	    while((cad = br.readLine()) != null)
	    {                   
                elementos = cad.split(",");
            }
            return elementos;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
