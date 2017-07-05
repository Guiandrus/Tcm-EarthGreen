/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.AlterarContasController.selecionada;
import Model.Conta;
import Model.DAO.FornecedorDAO;
import Model.Fornecedor;
import Model.ValidaDados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AlterarFornecedorController implements Initializable {

       @FXML
    private Button btnConfirmar;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNomeEmpresa;

    public static Fornecedor Selecionado;
    
    FornecedorDAO DAO = new FornecedorDAO();
    
    ValidaDados valida = new ValidaDados();
    boolean validacao;
    
    MostrarFornecedorController selecController = new MostrarFornecedorController();
    
    public void acaoDosBotoes(){
        
        btnConfirmar.setOnAction(event ->{
        Fornecedor fornecedor = new Fornecedor();
            
            if(tfNomeEmpresa.getText() != ""){
            fornecedor.setEmpresa(tfNomeEmpresa.getText());
            fornecedor.setEmail(tfEmail.getText());
            fornecedor.setTelefone(tfTelefone.getText());
            fornecedor.setCnpj(Selecionado.getCnpj());
            
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Alteração do fornecedor efetuada com sucesso");
            alert.showAndWait();
            DAO.update(fornecedor);
            Stage stage = (Stage) btnConfirmar.getScene().getWindow();
                        // do what you have to do
            stage.close();
            } else{
                
            }
            
            
        });
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfTelefone.setText("(00)0000-0000");
        tfEmail.setText("exemplo@exemplo.ex");
        acaoDosBotoes();
        Selecionado = MostrarFornecedorController.getFornecedorSelecionado();
    }    
    
}
