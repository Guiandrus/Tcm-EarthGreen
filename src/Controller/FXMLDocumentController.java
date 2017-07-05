/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.DAO.ContaDAO;
import Model.GerenciamentoImagens;
import Model.ValidaDados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.ButtonGroup;

/**
 *
 * @author Leo
 */
public class FXMLDocumentController implements Initializable {
  
   @FXML
    private TextField tfSenha;

    @FXML
    private Button btnEscolheImagem;

    @FXML
    private TextField tfLogin;

    @FXML
    private RadioButton radioFuncionario;

    @FXML
    private TextField tfEmail;

    @FXML
    private Button BtnCadastrar;

    @FXML
    private RadioButton radioAdm;

    @FXML
    private ImageView Imagem;

    @FXML
    private TextField tfNome;
    
    boolean validacao;
    
    final ToggleGroup group = new ToggleGroup();
    
    ValidaDados valida = new ValidaDados();
    
    public static String imagemSelec;

    public static String getImagemSelec() {
        return imagemSelec;
    }

    public static void setImagemSelec(String imagemSelec) {
        FXMLDocumentController.imagemSelec = imagemSelec;
    }
    
    public void acaoDosBotoes(){
        radioAdm.setToggleGroup(group);
        radioFuncionario.setToggleGroup(group);
        
        btnEscolheImagem.setOnMouseClicked(event -> {
           
            GerenciamentoImagens gerenciar = new GerenciamentoImagens();
            String caminho = gerenciar.getNovaImagem();
            Image image = new Image("file:///" + caminho);
            imagemSelec = "file:///"+caminho;
            this.Imagem.setImage(image);
            
            
            
        });
        
        BtnCadastrar.setOnAction(event ->{
            
        String nome,senha,login,email,tipoConta = null;
        
        nome = tfNome.getText();
        senha = tfSenha.getText();
        login = tfLogin.getText();
        email = tfEmail.getText();
        
        if(radioAdm.isSelected()){
            tipoConta = "admin";
        } else if (radioFuncionario.isSelected()){
            tipoConta = "funcionario";
        } 
            
            Conta conta = new Conta();
            conta.setNome(nome);
            conta.setEmail(email);
            conta.setLogin(login);
            conta.setSenha(senha);
            conta.setTipoConta(tipoConta);
            conta.setCaminhoimagem(imagemSelec);
            validacao = valida.validaemail(conta.getEmail());
            
            if(validacao == true){
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Cadastro do usuário efetuado com sucesso");
            alert.showAndWait();
             
            ContaDAO dao = new ContaDAO();
            dao.insert(conta);
                
            }
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {// TODO
        acaoDosBotoes();
    }    
    
}
