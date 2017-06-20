package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class CadastroLixoController implements Initializable {

    @FXML
    private TextField tfIDLixo;
        
    @FXML
    private ComboBox<?> cmbFornecedor;

    @FXML
    private Button btnCadastrar;

    @FXML
    private ComboBox<?> cmbLixo;

    @FXML
    private TextField tfQuantidade;
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
