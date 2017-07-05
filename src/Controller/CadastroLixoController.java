package Controller;

import Model.DAO.FornecedorDAO;
import Model.DAO.LixoDAO;
import Model.Fornecedor;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class CadastroLixoController implements Initializable {

    
    ObservableList<Fornecedor> fornecedor = FXCollections.observableArrayList();
    @FXML
    private RadioButton rbVidro;

    @FXML
    private RadioButton rbHospitalar;

    @FXML
    private RadioButton rbOrganico;

    @FXML
    private Button btnCadastrar;

    @FXML
    private RadioButton rbMetal;

    @FXML
    private RadioButton rbNuclear;

    @FXML
    private RadioButton rbPlastico;

    @FXML
    private ComboBox<Fornecedor> cbFornecedor;

    @FXML
    private RadioButton rbReciclavel;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfNome;
    
    FornecedorDAO DAO = new FornecedorDAO();
    
    Fornecedor forn = new Fornecedor();
    
    final ToggleGroup group = new ToggleGroup();
    
    LixoDAO lixoDAO = new LixoDAO();
    
    public void acaoDosBotoes(){
        
        btnCadastrar.setOnMouseClicked(event ->{
            
        String tipoLixo = null;
        
        Lixo lixo = new Lixo();
        lixo.setToneladas(Double.valueOf(tfQuantidade.getText()));
        lixo.setNome(tfNome.getText());
        if(rbReciclavel.isSelected()){
            tipoLixo = "Reciclavel";
        } else if(rbHospitalar.isSelected()){
            tipoLixo = "Hospitalar";
        } else if (rbMetal.isSelected()){
            tipoLixo = "Metal";
        } else if (rbNuclear.isSelected()){
            tipoLixo = "Nuclear";
        } else if (rbOrganico.isSelected()){
            tipoLixo = "Organico";
        } else if (rbPlastico.isSelected()){
            tipoLixo = "Plastico";
        } else if (rbVidro.isSelected()){
            tipoLixo = "Vidro";
        }
        lixo.setTipo(tipoLixo);
        
        lixoDAO.insert(lixo);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Cadastro do resíduo efetuado com sucesso");
            alert.showAndWait();
            tfNome.setText("");
            tfQuantidade.setText("");
        });
    }
    public void carregaComboBox(){
    
    cbFornecedor.setItems(DAO.select());
    
    }
    public void initialize(URL url, ResourceBundle rb) {
        acaoDosBotoes();
        carregaComboBox();
        forn.addFornecedores();
        rbHospitalar.setToggleGroup(group);
        rbMetal.setToggleGroup(group);
        rbNuclear.setToggleGroup(group);
        rbOrganico.setToggleGroup(group);
        rbPlastico.setToggleGroup(group);
        rbReciclavel.setToggleGroup(group);
        rbVidro.setToggleGroup(group);
    }    
    
}
