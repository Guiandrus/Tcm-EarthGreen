
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;


public class MostrarFornecedorController implements Initializable {

    
    @FXML
    private TableColumn<?, ?> tvEmail;

    @FXML
    private TableColumn<?, ?> tvTelefone;

    @FXML
    private TableColumn<?, ?> tvNome;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
