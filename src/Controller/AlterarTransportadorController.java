/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.TransportadorDAO;
import Model.Lixo;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AlterarTransportadorController implements Initializable {

    
    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField tfContato;

    @FXML
    private TextField tfCnpj;

    @FXML
    private TextField tfNomeTransportadora;

    @FXML
    private ComboBox<String> comboTipoMaterial;
    
    public static Transportadora selecionado;
    
    TransportadorDAO DAO = new TransportadorDAO();
    
    public void carregaComboBox(){
    
    ObservableList<String> tipoMaterial = FXCollections.observableArrayList();
    tipoMaterial.addAll("Metal", "Reciclavel", "Vidro", "Organico", "Hospitalar", "Nuclear", "Plastico");
    comboTipoMaterial.setItems(tipoMaterial);
    
    }
    
    public void acaoDosBotoes(){
        
        
        btnConfirmar.setOnMouseClicked(event ->{
            Transportadora transportadora = new Transportadora();
            transportadora.setNome(tfNomeTransportadora.getText());
            transportadora.setEmail(tfContato.getText());
            transportadora.setTipoDeLixo(comboTipoMaterial.getValue());
            transportadora.setCnpj(selecionado.getCnpj());
            
            DAO.update(transportadora);
            
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Alteração da transportadora efetuada com sucesso");
            alert.showAndWait();
                        Stage stage = (Stage) btnConfirmar.getScene().getWindow();
                        // do what you have to do
            stage.close();
                    
            
        });
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregaComboBox();
        acaoDosBotoes();
        selecionado = MostraTranportadoraController.getSelecionado();
    }    
    
}
