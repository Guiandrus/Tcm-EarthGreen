/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.AlterarContasController.selecionada;
import Model.Conta;
import Model.DAO.LixoDAO;
import Model.Lixo;
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
 * @author Leo
 */
public class AlteraResíduosController implements Initializable {

    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField tfIDLixo;
    
    @FXML
    private TextField tfQuantidade;

    @FXML
    private ComboBox<String> cmbLixo;
    
    LixoDAO DAO = new LixoDAO();
    
    private Lixo selecionado;
    
    public void acaoDosBotoes(){
        
        
        
        btnConfirmar.setOnMouseClicked(event ->{
            Lixo lixo = new Lixo();
            lixo.setNome(selecionado.getNome());
            lixo.setToneladas(Double.valueOf(tfQuantidade.getText()));
            lixo.setTipo(cmbLixo.getValue());
            DAO.update(lixo);
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Alteração do resíduo efetuada com sucesso");
            alert.showAndWait();
            Stage stage = (Stage) btnConfirmar.getScene().getWindow();
                        // do what you have to do
            stage.close();
        });
        
        
    }
    
    public void carregaComboBox(){
        
    
    ObservableList<String> tipoMaterial = FXCollections.observableArrayList();
    tipoMaterial.addAll("Metal", "Reciclavel", "Vidro", "Organico", "Hospitalar", "Nuclear", "Plastico");
    cmbLixo.setItems(tipoMaterial);
    
    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        carregaComboBox();
        acaoDosBotoes(); 
        selecionado = MostraLixoController.getLixoSelecionado();
        
        
    }    
    
}
