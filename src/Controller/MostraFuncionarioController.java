
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;


public class MostraFuncionarioController implements Initializable {

    
    
    @FXML
    private TableColumn<?, ?> tvEmail;

    @FXML
    private Text Funcionarios;

    @FXML
    private TableColumn<?, ?> tvLogin;

    @FXML
    private TableColumn<?, ?> tvSalario;

    @FXML
    private TableColumn<?, ?> tvSenha;

    @FXML
    private TableColumn<?, ?> tvNome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    tvNome.setStyle("");
    }    
    
}
