package CRDGenerico;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class documentPDF 
{
    String rutaArchivo = "";
    
    public documentPDF(String rutaArchivo)
    {
        this.rutaArchivo = rutaArchivo;
        
    }
    
    public void escribeArchivoPDF()
    {
        Document PDF = new Document();
        try
        {
            FileOutputStream archivoPDF = new FileOutputStream(rutaArchivo);
            PdfWriter pdfw = PdfWriter.getInstance(PDF, archivoPDF);
            pdfw.setInitialLeading(20);
            PDF.open();
            agregarTexto(PDF, "Primer texto:", null, 0);
            agregarLineasEnBlanco(PDF, 20);
            Font fuente = FontFactory.getFont("Arial", 22, Font.BOLD, BaseColor.BLUE);
            agregarTexto(PDF, "Ahora con settings:", fuente, 90);
            agregarCodigoBarras128(PDF, pdfw, "9781935182610", 50);
            PDF.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarLineasEnBlanco(Document PDF, int nLineas) 
    {
        Paragraph parrafo = new Paragraph();
        for (int i = 0; i < nLineas; i++) 
            parrafo.add(new Paragraph(" "));
        try
        {
            PDF.add(parrafo);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void agregarCodigoBarras128(Document PDF, PdfWriter pdfw, String codigoBarras, int x)
    {
        Barcode128 codigo = new Barcode128();
        codigo.setCodeType(Barcode128.CODE128);
        codigo.setCode(codigoBarras);
        Image imagen = codigo.createImageWithBarcode(pdfw.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);        
        imagen.setIndentationLeft(x);
        try
        {
            PDF.add(imagen);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void agregarTexto(Document PDF, String texto, Font fuente, float x)
    {
        Paragraph parrafo;
        if(fuente != null)
            parrafo = new Paragraph(texto, fuente);
        else
            parrafo = new Paragraph(texto);
        if(x != 0)
            parrafo.setIndentationLeft(x);
        try
        {
//            if(fuente == null)
                PDF.add(parrafo);
//            else
//                PDF.add(new Paragraph(texto, fuente));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Aplicacion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
