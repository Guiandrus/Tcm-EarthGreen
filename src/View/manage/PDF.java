package View.manage;

import Model.DAO.ContaDAO;
import Model.DAO.FornecedorDAO;
import Model.DAO.LixoDAO;
import Model.DAO.TransportadorDAO;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class PDF {
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    LixoDAO lixoDAO = new LixoDAO();
    ContaDAO contaDAO = new ContaDAO();
    TransportadorDAO transportadorDAO = new TransportadorDAO();
    
    public void gerarPdf(){
        
        Document documento = new Document();
        
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\Aluno\\Desktop\\Cadastros.pdf"));
            documento.open();
            
            
            try {
                Paragraph paragraph = new Paragraph();
                paragraph.add("");
                documento.add(geraTabelaConta());
                documento.add(paragraph);
                documento.add(geraTabelaLixo());
                documento.add(paragraph);
                documento.add(geraTabelaFornecedor());
                documento.add(paragraph);
                documento.add(geraTabelaTransportadora());
            } catch (IOException ex) {
                
            } 
            documento.close();
        } catch (FileNotFoundException | DocumentException ex) {
            
        }
    }
    
    public PdfPTable geraTabelaConta() throws IOException, BadElementException{
        
        // Tabela de Usuarios
        PdfPTable tabela = new PdfPTable(4);
        PdfPCell linha;
        linha = new PdfPCell(new Phrase("Usuarios"));
        linha.setHorizontalAlignment(Element.ALIGN_CENTER);
        linha.setColspan(4);
        tabela.addCell(linha);
        tabela.addCell("Nome");
        tabela.addCell("Login");
        tabela.addCell("Email");
        tabela.addCell("TipoConta");
        for (int i = 0; i < contaDAO.select().size(); i++) {
            
            tabela.addCell(contaDAO.select().get(i).getNome());
            tabela.addCell(contaDAO.select().get(i).getLogin());
            tabela.addCell(contaDAO.select().get(i).getEmail());
            tabela.addCell(contaDAO.select().get(i).getTipoConta());
            
        }
        return tabela;
    }
    
     public PdfPTable geraTabelaLixo(){
        
        // Tabela de Usuarios
        PdfPTable tabela = new PdfPTable(3);
        PdfPCell linha;
        linha = new PdfPCell(new Phrase("Residuos"));
        linha.setHorizontalAlignment(Element.ALIGN_CENTER);
        linha.setColspan(3);
        tabela.addCell(linha);
        tabela.addCell("Nome");
        tabela.addCell("Tipo");
        tabela.addCell("Quantidade (Toneladas)");
        
        for (int i = 0; i < lixoDAO.select().size(); i++) {
            
            
            tabela.addCell(lixoDAO.select().get(i).getNome());
            tabela.addCell(lixoDAO.select().get(i).getTipo());
            tabela.addCell(String.valueOf(lixoDAO.select().get(i).getToneladas()));
            
            
        }
        return tabela;
    }
    
     public PdfPTable geraTabelaFornecedor(){
        
        // Tabela de Usuarios
        PdfPTable tabela = new PdfPTable(4);
        PdfPCell linha;
        linha = new PdfPCell(new Phrase("Fornecedores"));
        linha.setHorizontalAlignment(Element.ALIGN_CENTER);
        linha.setColspan(4);
        tabela.addCell(linha);
        tabela.addCell("Nome");
        tabela.addCell("Email");
        tabela.addCell("Telefone");
        tabela.addCell("Cnpj");
        for (int i = 0; i < fornecedorDAO.select().size(); i++) {
            
            
            tabela.addCell(fornecedorDAO.select().get(i).getEmpresa());
            tabela.addCell(fornecedorDAO.select().get(i).getEmail());
            tabela.addCell(fornecedorDAO.select().get(i).getTelefone());
            tabela.addCell(fornecedorDAO.select().get(i).getCnpj());
            
        }
        return tabela;
    }
     
     public PdfPTable geraTabelaTransportadora(){
        
        // Tabela de Usuarios
        PdfPTable tabela = new PdfPTable(4);
        PdfPCell linha;
        linha = new PdfPCell(new Phrase("Transportadoras"));
        linha.setHorizontalAlignment(Element.ALIGN_CENTER);
        linha.setColspan(4);
        tabela.addCell(linha);
        tabela.addCell("Nome");
        tabela.addCell("Contato");
        tabela.addCell("Tipo De Lixo");
        tabela.addCell("Cnpj");
        for (int i = 0; i < transportadorDAO.select().size(); i++) {
            
            
            tabela.addCell(transportadorDAO.select().get(i).getNome());
            tabela.addCell(transportadorDAO.select().get(i).getEmail());
            tabela.addCell(transportadorDAO.select().get(i).getTipoDeLixo());
            tabela.addCell(transportadorDAO.select().get(i).getCnpj());
            
        }
        return tabela;
    }

    
}
