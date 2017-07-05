
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CadastroFornecedorController implements Initializable {
    
    @FXML
    private TextField tfTelefone;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNomeEmpresa;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
