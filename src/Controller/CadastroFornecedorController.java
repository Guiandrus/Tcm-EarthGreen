
package Controller;

import Model.DAO.FornecedorDAO;
import Model.Fornecedor;
import Model.ValidaDados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CadastroFornecedorController implements Initializable {
    
    @FXML
    private TextField tfTelefone;   
    
    @FXML
    private TextField tfCnpj;
    
    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNomeEmpresa;
    
    boolean valida;
    
    FornecedorDAO DAO = new FornecedorDAO();
    
    ValidaDados validaDados = new ValidaDados();
    
    boolean validacao;
    public void acaoDosBotoes(){
        btnCadastrar.setOnAction(event ->{
            
        String empresa,telefone,cnpj,email = null;
        
        
        empresa = tfNomeEmpresa.getText();
        telefone = tfTelefone.getText();
        cnpj = tfCnpj.getText();
        email = tfEmail.getText();
        
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setEmpresa(empresa);
            fornecedor.setTelefone(telefone);
            fornecedor.setCnpj(cnpj);
            fornecedor.setEmail(email);
        validacao = validaDados.validaemail(fornecedor.getEmail());
        
        if (validacao == true){
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Cadastro do fornecedor efetuado com sucesso");
            alert.showAndWait();
            DAO.insert(fornecedor);
        }else {
            tfEmail.setStyle("-fx-border-color: RED;"
                    + "-fx-border-width: 3;");
        }
            
        
      });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acaoDosBotoes();
    }    
    
}
