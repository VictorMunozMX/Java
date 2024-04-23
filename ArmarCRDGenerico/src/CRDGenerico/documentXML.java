package CRDGenerico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JFileChooser;
import java.util.ArrayList;


public class documentXML 
{    
    private Document document;
    private Element rootNode;
    private List listaNodos;
    private int cadenaLength;
    private int iCVVO = 0;
    private int CVVO = 0;
    private int CVVOB = 0;
    
    public documentXML()
    {
        
    }
    public documentXML(String archivo)
    {
       File XMLFile = new File(archivo);
       SAXBuilder builder = new SAXBuilder();
       try
       {
            document = (Document) builder.build(XMLFile);
            rootNode = document.getRootElement();
            cadenaLength = Integer.parseInt(rootNode.getAttributeValue("cadenaLength"));
            if (!rootNode.getAttributeValue("iCVVOffset").equals(""))
            {
                iCVVO = Integer.parseInt(rootNode.getAttributeValue("iCVVOffset"));
                CVVO = Integer.parseInt(rootNode.getAttributeValue("CVVOffset"));
                CVVOB = Integer.parseInt(rootNode.getAttributeValue("CVVBandaOffset"));
            }
            listaNodos = rootNode.getChildren();
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
       }
    }
    
    private String procesaLinea(String cad, int consecutivo)
    {
        String cadProc = padLeft(String.valueOf(consecutivo), 6, '0'), iCVV = "", CVV = "";
        Element nodo;
        String tmp = "";
        if(cad.trim().length() <= cadenaLength)
            return "";
        for (int i = 0; i < listaNodos.size(); i++)
        {
            nodo = (Element) listaNodos.get(i);
            tmp = cad.substring(Integer.parseInt(nodo.getAttributeValue("inicial")), Integer.parseInt(nodo.getAttributeValue("final")));
            cadProc += nodo.getValue().concat(tmp);
            if (!(nodo.getAttributeValue("nombre").equals("banda") && iCVVO != 0))
                continue;
            iCVV = cad.substring(iCVVO, iCVVO + 3);
            CVV = cad.substring(CVVO, CVVO + 3);
            if (tmp.indexOf(CVV) < CVVOB)
            {
                JOptionPane.showMessageDialog(null, "Aparicion de CVV antes de la data discretionary", "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
                cadProc += iCVV;
            }   
            else
                cadProc += "\"\"" + tmp.replace(CVV, iCVV);
        }        
        return cadProc;
    }
    
    public Boolean procesaArchivo(String rutaArchivo)
    {
        File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
        String cad = "", tmp = "";
        List<String> listaRegistros = new ArrayList<String>();
        int i = 1;
        try
	{
            archivo = new File (rutaArchivo);
	    fr = new FileReader (archivo);
	    br = new BufferedReader(fr);
	    while((cad = br.readLine()) != null)
	    {
                tmp = procesaLinea(cad, i);
                if (tmp.equals(""))
                    continue;
                listaRegistros.add(tmp);
                i++;
            }
            escribeArchivo(rutaArchivo.concat(".CRD"), listaRegistros);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }        
        return true;
    }
    
    public String rutaArchivo()
    {
        JFileChooser cuadroDialogo = new JFileChooser("C:\\Users\\vbejarano\\Documents\\vbejarano\\Implementaciones");        
        int seleccion = cuadroDialogo.showOpenDialog(null);
        File archivo = cuadroDialogo.getSelectedFile();
        if(seleccion == JFileChooser.APPROVE_OPTION)
            return archivo.getAbsolutePath(); 
        return "";
    }
    
    private String padLeft(String s, int n, char caracter) 
    {
        return String.format("%1$" + n + "s", s).replace(' ', caracter);  
    }
    
    private void escribeArchivo(String archivo, String cad)
    {
	try
	{
	    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
            escritor.write(cad);
            escritor.newLine();
            escritor.close();
	}
	catch(Exception e)
	{
            System.out.println(e.getMessage());
	}		
    }
    
        private void escribeArchivo(String rutaArchivo, List<String> datos)
    {
	try
	{
//	    ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(new File(rutaArchivo)));
//            archivo.writeObject(datos);            
//            archivo.close();
            BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo, true));            
            for(String cadena:datos)
            {
                escritor.write(cadena);
                escritor.newLine();                
            }
            escritor.close();
	}
	catch(Exception e)
	{
            System.out.println(e.getMessage());
	}		
    }
    
}
