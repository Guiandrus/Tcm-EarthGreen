/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.DAO.ContaDAO;
import Model.ValidaDados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.ButtonGroup;

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
    
    boolean validacao;
    
    final ToggleGroup group = new ToggleGroup();
    
    ValidaDados valida = new ValidaDados();
    
    public void acaoDosBotoes(){
        radioAdm.setToggleGroup(group);
        radioFuncionario.setToggleGroup(group);
        
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
            validacao = valida.validaemail(conta);
            
            if(validacao == true){
                
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
