/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class CadastraTransportadorController implements Initializable {

    
    @FXML
    private TextField tfContato;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField tfCnpj;

    @FXML
    private TextField tfNomeTransportadora;

    @FXML
    private ComboBox<?> comboTipoMaterial;
    
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
        
    }    
    
}
