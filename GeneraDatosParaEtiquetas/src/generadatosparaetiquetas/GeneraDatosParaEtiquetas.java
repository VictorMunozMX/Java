/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadatosparaetiquetas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author vbejarano
 */
public class GeneraDatosParaEtiquetas {

    static int contador = 0;
    static List<String> lista = new ArrayList<String>();
    
    public static void main(String[] args) 
    {
//        datos(50000,500);
//        recorrerArchivo("C:\\Users\\vbejarano\\Documents\\vbejarano\\Implementaciones\\Seguros\\Guatemala Carne PSM AG 2796 BD.txt");
//        sacarArchivos("C:\\Users\\vbejarano\\Documents\\TFS\\TgsCard.SiVale\\V-1.0.0-SV\\Ejecutable\\2014-09-12\\DataTest");
//        distribuyeOrdenes("C:\\Users\\vbejarano.PRODUCCION\\Documents\\NetBeansProjects\\GeneraDatosParaEtiquetas\\Data.txt");
//        generaDetalleCintillo("C:\\Users\\vbejarano.PRODUCCION\\Documents\\vbejarano\\Implementaciones\\Bansefi\\Workspace\\Cintillos.txt");
        generadorEstados("C:\\Users\\vbejarano.PRODUCCION\\Documents\\NetBeansProjects\\GeneraDatosParaEtiquetas\\ESTADOS.txt");
    }
    
    static void datos (int total, int porCaja)
    {
        int totalCajas = total/porCaja;    
        int totalIntermedio = totalCajas * porCaja;
        int restante = 0;
        int contadorFinal = 0;
        String cad = "";
        if(totalIntermedio < total)
        {
            restante = total - totalIntermedio;
            totalCajas++;
        }
        else
            restante = porCaja;
        for (int i=1; i <= totalCajas; i++)
        {
            if(i == totalCajas)
                contadorFinal = contador + restante;
            else
                contadorFinal = contador + porCaja;
            cad = i + ";" + totalCajas + ";" + (contador + 1) + ";" + contadorFinal;
            contador = contadorFinal;
            System.out.println(cad);
        }
    }
    
    static void recorrerArchivo(String ruta)
    {
	BufferedReader br = null;
	String cad = "";
        String cadFinal = "";
        List<String> registros = new ArrayList<>();
        String[] elementos;
        String[] elementosA;  
        int i = 1;
        try
	{
            br = new BufferedReader(new InputStreamReader (new FileInputStream (ruta), "ISO-8859-15"));
	    while((cad = br.readLine()) != null)
	    {
                elementos = cad.split(";", -1);  
                if(elementos.length != 10)
                {
                    JOptionPane.showMessageDialog(null, "Hay un registro con mas elementos de los esperados", "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                elementos[0] = padLeft(elementos[0], 6, '0');
                cadFinal = elementos[0] + "$" + elementos[1] + ")" + elementos[4] + "#" + elementos[2]
                        + "&" + elementos[3] + "*hosp*" + elementos[7] + "*far*" + elementos[8] + "*red*";
                elementosA = elementos[5].split("\\|");
                i = 1;
                for(String tmp : elementosA)
                {
                    cadFinal += "*carne" + i + "*" + tmp;
                    i++;
                }
                cadFinal += completa("", "carne", i);
                elementosA = elementos[6].split("\\|");
                i = 1;
                for(String tmp : elementosA)
                {
                    cadFinal += "*nomb" + i + "*" + tmp;
                    i++;
                }
                cadFinal += completa("", "nomb", i);
                cadFinal += completa("", "fin", 1);
                i--;
                cadFinal = cadFinal.replaceFirst("fin" + i + "*", "fin" + i + "*---------------------------Última línea--------------------------");
                
                registros.add(cadFinal);
            }
            escribeArchivo(ruta.replace("txt", "CRD"), registros);
	}
	catch(Exception e)
	{
            JOptionPane.showMessageDialog(null, e.getMessage() + ":Error al abrir el archivo", "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
	}        
    }
        
    static void sacarArchivos(String rutaPrincipal)
    {
        File directorio = new File(rutaPrincipal);
        File archivo;
        File archivosCarpeta;
        String[] carpetas = directorio.list();
        String[] archivos;
        for(String carpeta : carpetas)
        {
            archivosCarpeta = new File(rutaPrincipal + "\\" + carpeta);
            archivos = archivosCarpeta.list();
            if(archivos == null)
                continue;
            for(String nombreArchivo : archivos)
            {
                try
                {
                    Files.copy(Paths.get(rutaPrincipal + "\\" + carpeta + "\\" + nombreArchivo), Paths.get(rutaPrincipal + "\\" + nombreArchivo));
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
    static String completa(String cad, String sentinel, int i)
    {
        for(int j = i; j < 8; j++ )
        {
            cad += "*" + sentinel + j + "*";
        }
        return cad;
    }
    
    static String padRight(String s, int n, char caracter) 
    {
         return String.format("%1$-" + n + "s", s).replace(' ', caracter);
    }

    static String padLeft(String s, int n, char caracter) 
    {
        return String.format("%1$" + n + "s", s).replace(' ', caracter);  
    }
    
    static void escribeArchivo(String archivo, List<String> registros)
    {
	try
	{
//	    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
            Writer escritor = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo),"UTF8"));
            for(String registro:registros)
            {
                escritor.write(registro + "\n");                
            }
            escritor.close();
	}
	catch(Exception e)
	{
            System.out.println(e.getMessage());
	}		
    }
    
    static void distribuyeOrdenes(String ruta)
    {
//        File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
//        List<String> registros = new ArrayList<>();
        String[] elementos = null;
        String cad = "";
        String orden = "";
        try
        {
            fr = new FileReader (ruta);
	    br = new BufferedReader(fr);
	    while((cad = br.readLine()) != null)
	    {
                elementos = cad.split(",");
            }
            for(int i = 0; i < elementos.length; i++ )
            {
                if(i == 0)
                {
                    orden = elementos[0];
                    continue;
                }
//                orden = generaSecuenciaCortes(orden, Integer.parseInt(elementos[i]));
                orden = generaSecuenciaOrden(orden, Integer.parseInt(elementos[i]));
            }
            escribeArchivo("distOrdenes.txt", lista);
        }
        catch(Exception e)
        {
            
        }
    }
    
    static String generaSecuenciaCortes(String orden, int cantidad)
    {        
        int iterador = 1;
        orden = "0001";
        int j = 1;
        for(int i = 0; i < cantidad; i++)
        {
            if(i == 350 * j)
            {
                iterador++;
                orden = padLeft(String.valueOf(iterador), 4, '0');
                j++;
            }
            lista.add(orden);
        }
        iterador++;
        orden = padLeft(String.valueOf(iterador), 4, '0'); 
        return orden;
    }
    
    static String generaSecuenciaOrden(String orden, int cantidad)
    {        
        String parteFija = orden.substring(0, 4);
        int iterador = Integer.parseInt(orden.substring(4));
        int j = 1;
        for(int i = 0; i < cantidad; i++)
        {
            if(i == 2100 * j)
            {
                iterador++;
                orden = parteFija + padLeft(String.valueOf(iterador), 4, '0');
                j++;
            }
            lista.add(orden);
        }
        iterador++;
        orden = parteFija + padLeft(String.valueOf(iterador), 4, '0'); 
        return orden;
    }
    
    static void generaDetalleCintillo(String ruta)
    {
        FileReader fr = null;
	BufferedReader br = null;
        String[] elementos = null;
        String cad = "";
        String cintillo = "";
        int j,k;
        try
        {
            fr = new FileReader (ruta);
	    br = new BufferedReader(fr);
	    while((cad = br.readLine()) != null)
	    {
                elementos = cad.split(","); 
                j = Integer.parseInt(elementos[0]);
                k = Integer.parseInt(elementos[1]);
                cintillo = elementos[2];
                for(int i = j; i < k + 1; i++ )
                {
                    lista.add(i + "," + cintillo);
                }
            }
            escribeArchivo("detalleCintillos.txt", lista);
        }
        catch(Exception e)
        {
            
        }
    }
    
    static void generadorEstados(String ruta)
    {
     FileReader fr = null;
	BufferedReader br = null;
        String[] elementos = null;
        String cad = "";
        String cintillo = "";
        int k;
        String estado = "";
        try
        {
            fr = new FileReader (ruta);
	    br = new BufferedReader(fr);
	    while((cad = br.readLine()) != null)
	    {
                elementos = cad.split(","); 
                estado = elementos[0];
                k = Integer.parseInt(elementos[1]);
                for (int i = 0; i < k; i++)
                {
                    lista.add(estado);                   
                }                
            }
            escribeArchivo("detalleEstados.txt", lista);
        }
        catch(Exception e)
        {
            
        }   
    }
}
