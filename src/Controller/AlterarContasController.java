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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class AlterarContasController implements Initializable {

    @FXML
    private TextField tfSenha;

    @FXML
    private Button btnAlterar;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNome;
    
    
    ContaDAO contaDAO = new ContaDAO();
    
    public static Conta selecionada;
    boolean validacao;        
    ValidaDados valida = new ValidaDados();
    public void acaoDosBotoes(){
        
        
        
        btnAlterar.setOnMouseClicked(event ->{
            Conta contaa = new Conta();

            contaa.setNome(tfNome.getText());
            contaa.setSenha(tfSenha.getText());
            contaa.setLogin(selecionada.getLogin());
            contaa.setEmail(tfEmail.getText());
            validacao = valida.validaemail(contaa.getEmail());
            
            if(validacao == true){
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Alteração da conta efetuada com sucesso");
            alert.showAndWait();
            contaDAO.update(contaa);
            
            Stage stage = (Stage) btnAlterar.getScene().getWindow();
                        // do what you have to do
                        stage.close();
            }
            
            
            
        });
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       acaoDosBotoes();
       selecionada = MostraFuncionarioController.getContaSelecionada();
       
       
    }    
    
}
