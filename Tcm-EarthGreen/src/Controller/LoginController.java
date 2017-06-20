/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TCM;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {
    
    @FXML
    private Button btn_Logar;

    @FXML
    private TextField tfLogin_login;

    @FXML
    private PasswordField tfSenha_senha;

    
    public void acaoDosBotoes(){
        
        btn_Logar.setOnAction(event ->{
        
            String login = tfLogin_login.getText();
            String senha = tfSenha_senha.getText();
            
            if("admin".equals(login) && "admin".equals(senha)){
                try {
                    TCM tcm = new TCM();
                    tcm.abreTela("TelaADM");
                } catch (Exception e) {
                }

            }
            
        });
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       acaoDosBotoes();
      
    }    
    
}
