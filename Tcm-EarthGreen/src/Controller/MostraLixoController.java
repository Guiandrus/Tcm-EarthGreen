package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;


public class MostraLixoController implements Initializable {

    
    
    @FXML
    private TableColumn<?, ?> cmmTipoLixo;

    @FXML
    private TableColumn<?, ?> cmbQTD;

    @FXML
    private TableColumn<?, ?> cmbID_Entrega;

    @FXML
    private TableColumn<?, ?> cmbEMpresa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
