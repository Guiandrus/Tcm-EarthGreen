/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.DAO.ContaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Leo
 */
public class FXMLDocumentController implements Initializable {
  
   @FXML
    private TextField tfLogin;
    
   @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfSalario;

    @FXML
    private TextField tfEmail;

    @FXML
    private Button BtnCadastrar;

    @FXML
    private TextField tfNome;
    
    @FXML
    private RadioButton radioFuncionario;
    
    @FXML
    private RadioButton radioAdm;
    
    public void acaoDosBotoes(){
        BtnCadastrar.setOnAction(event ->{
        String nome,senha,login,email;
        nome = tfNome.getText();
        senha = tfSenha.getText();
        login = tfLogin.getText();
        email = tfEmail.getText();
        
            Conta conta = new Conta();
            conta.setNome(nome);
            conta.setEmail(email);
            conta.setLogin(login);
            conta.setSenha(senha);
            
            ContaDAO dao = new ContaDAO();
            dao.insert(conta);
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {// TODO
        
    }    
    
}
