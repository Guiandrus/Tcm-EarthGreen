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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class AlterarContasController implements Initializable {

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfLogin;

    @FXML
    private Button btnAlterar;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNome;
    
    public static Conta conta;
    
    ContaDAO contaDAO = new ContaDAO();
    
    
    public void acaoDosBotoes(){
        
        
        btnAlterar.setOnMouseClicked(event ->{
            String nome,senha,login,email;
            Conta contaa = new Conta();
            contaa.setNome(tfNome.getText());
            contaa.setSenha(tfSenha.getText());
            contaa.setLogin(tfLogin.getText());
            contaa.setEmail(tfEmail.getText());
            contaa.setId(conta.getId());
            contaDAO.update(contaa);
            
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       conta = MostraFuncionarioController.getContaSelecionada();
       acaoDosBotoes();
       
       
    }    
    
}
