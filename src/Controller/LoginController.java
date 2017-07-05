/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.DAO.ContaDAO;
import Model.jbdc.ConnectionFactory;
import View.manage.TCM;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    Conta conta = new Conta();
    
    
    public void acaoDosBotoes(){
    
        btn_Logar.setOnAction(event ->{
        
            String login = tfLogin_login.getText();
            String senha = tfSenha_senha.getText();
            
            ContaDAO dao = new ContaDAO();
            
            if("admin".equals(login) && "admin".equals(senha)){
                try {
                    TCM tcm = new TCM();
                    tcm.abreTela("TelaADM");
                } catch (Exception e) {
                }
                

            } else {
                ObservableList<Conta> contas = contas = dao.select();
            for (int i = 0; i < contas.size(); i++) {
                if(login.equals(contas.get(i).getLogin()) && senha.equals(contas.get(i).getSenha())){
                    
                    if("admin".equals(contas.get(i).getTipoConta())){
                        try {
                            
                            
                        TCM tcm = new TCM();
                        TCM.setLogada(contas.get(i));
                        tcm.abreTela("TelaADM");
                        
                        Stage stage = (Stage) btn_Logar.getScene().getWindow();
                        // do what you have to do
                        stage.close();
             
         
                    } catch (Exception e) {
                            System.out.println(""+e.getLocalizedMessage());
             }
            } else {
                    try {
                        TCM tcm = new TCM();
                        tcm.abreTela("TelaFuncionario");
                        Stage stage = (Stage) btn_Logar.getScene().getWindow();
                        // do what you have to do
                        stage.close();
                    } catch (Exception e) {
                        System.out.println("erro: "+e.getLocalizedMessage());
                    }
                    }
                
                
            } else {
                }  
            }   
            }
            
        });
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       acaoDosBotoes();
      
    }    
    
}
