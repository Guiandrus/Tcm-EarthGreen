/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.DAO.ContaDAO;
import View.manage.TCM;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Leo
 */
public class TelaADMController implements Initializable {
    
    @FXML
    private MenuItem miCadastraPedido;
    
    @FXML
    private MenuItem miMostraPedido;

    @FXML
    private Label lbNome;
   
    @FXML
    private Button btnLogout;
    
    @FXML
    private MenuItem miFornecedor;

    @FXML
    private MenuItem miTransportadora;

    @FXML
    private MenuItem cadContas;

    @FXML
    private MenuItem cadTransportadora;

    @FXML
    private MenuItem cadResiduo;
    
    @FXML
    private ImageView imagem;

    @FXML
    private MenuItem miResiduos;

    @FXML
    private MenuItem cadFornecedor;

    @FXML
    private MenuItem miFuncionario;

    @FXML
    private Button btnInfo;
    
    @FXML
    private Button btnRelatorio;
    
    TCM tcm = new TCM();
    
    public void acaoDosBotoes(){
         btnRelatorio.setOnMouseClicked(event ->{
             tcm.abreTela("Relatorio");
         });
         miFornecedor.setOnAction(event ->{
             tcm.abreTela("MostrarFornecedor");
         });
         miTransportadora.setOnAction(event ->{
             tcm.abreTela("MostraTransportadora");
         });
         miFuncionario.setOnAction(event ->{
             tcm.abreTela("MostraFuncionario");
         });
         miResiduos.setOnAction(event ->{
             tcm.abreTela("MostraLixo");
         });
         cadContas.setOnAction(event ->{
             tcm.abreTela("Cadastro");
         });
         cadFornecedor.setOnAction(event ->{
             tcm.abreTela("CadastroFornecedor");
         });
         cadResiduo.setOnAction(event ->{
             tcm.abreTela("CadastroLixo");
         });
         cadTransportadora.setOnAction(event ->{
             tcm.abreTela("CadastraTransportador");
         });
         miCadastraPedido.setOnAction(event ->{
             tcm.abreTela("Pedidos");
         });
         miMostraPedido.setOnAction(event ->{
             tcm.abreTela("MostraPedidos");
         });
         btnInfo.setOnAction(event ->{
         
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();    
        try {
            desktop.open(new File("src\\Paginas_De_Ajuda\\Help dos adm.docx"));
        } catch (IOException ex) {
            
        }
         });
         btnLogout.setOnMouseClicked(event ->{
             tcm.abreTela("Login");
             Stage stage = (Stage) btnLogout.getScene().getWindow();
    // do what you have to do
            stage.close();
             
         });
         
         
    }
    
    public void setaLabel(){
        if(TCM.getLogada().getNome() != null){
            String nome = TCM.getLogada().getNome();
            System.out.println("Nome : "+TCM.getLogada().getNome());
        lbNome.setText(""+nome);
        } else{
            
        }
    }
    
    public void setaImagem(){
        if(TCM.getLogada().getCaminhoimagem() != null){  
        
        System.out.println(""+TCM.getLogada().getCaminhoimagem());
        Image image = new Image(TCM.getLogada().getCaminhoimagem());
        this.imagem.setImage(image);
        
        } else{
        
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        acaoDosBotoes();
        //pdf.criaPDF();
        setaImagem();
        setaLabel();
    }    
    
}
