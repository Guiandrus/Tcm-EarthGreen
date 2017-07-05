/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.TransportadorDAO;
import Model.Transportadora;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
    private ComboBox<String> comboTipoMaterial;
    
    public void carregaComboBox(){
        
    
    ObservableList<String> tipoMaterial = FXCollections.observableArrayList();
    tipoMaterial.addAll("Metal", "Reciclavel", "Vidro", "Organico", "Hospitalar", "Nuclear", "Plastico");
    comboTipoMaterial.setItems(tipoMaterial);
    
    }
    
    public void acaoDosBotoes(){
        
        btnCadastrar.setOnMouseClicked(event ->{
        
            Transportadora transportadora = new Transportadora();
            transportadora.setNome(tfNomeTransportadora.getText());
            transportadora.setCnpj(tfCnpj.getText());
            transportadora.setEmail(tfContato.getText());
            transportadora.setTipoDeLixo(comboTipoMaterial.getValue());
            TransportadorDAO DAO = new TransportadorDAO();
            DAO.insert(transportadora);
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Cadastro da transportadora efetuado com sucesso");
            alert.showAndWait();
            tfCnpj.setText("");
            tfContato.setText("");
            tfNomeTransportadora.setText("");
            
        });
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       carregaComboBox();
       acaoDosBotoes();
        
    }    
    
}
