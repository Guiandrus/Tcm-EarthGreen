/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aluno
 */

    import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDF {
    
    public void abrePDF(){
java.awt.Desktop desktop = java.awt.Desktop.getDesktop();    
        try {
            desktop.open(new File("C:\\Users\\Aluno\\Desktop\\Teste.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void criaPDF(){
        Document document = new Document();
          try {

              PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Aluno\\Desktop\\Teste.pdf"));
              document.open();

              // adicionando um parágrafo no documento
              document.add(new Paragraph("Gerando PDF - Java"));
}
          catch(DocumentException de) {
              System.err.println(de.getMessage());
          }
          catch(IOException ioe) {
              System.err.println(ioe.getMessage());
          }
          document.close();
    }
    
    public static void main(String[] args) {
           // criação do documento
          
      }   
    }
// para abrir o arquivo

