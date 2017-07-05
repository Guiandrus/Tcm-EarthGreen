/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.manage.TCM;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Leo
 */
public class TelaFuncionarioController implements Initializable {

    
    @FXML
    private MenuItem miListagemRecebimento;

    @FXML
    private Button btnLogout;

    @FXML
    private MenuButton comboResiduos;

    @FXML
    private MenuItem miCadastrarResiduos;

    @FXML
    private MenuItem miCadastrarFornecedor;

    @FXML
    private MenuItem miListagemResiduos;

    @FXML
    private MenuButton comboRecebimento;

    @FXML
    private MenuButton comboFornecedor1;

    @FXML
    private MenuButton comboFornecedor;

    @FXML
    private MenuItem miCadastrarRecebimento;

    @FXML
    private MenuItem miCadastrarTransportador;

    @FXML
    private MenuItem miListarTransportador;

    @FXML
    private MenuItem miListarFornecedor;
    
    
    
    public void acaoDosBotoes(){
        TCM tcm = new TCM();
        miCadastrarFornecedor.setOnAction(event ->{
        tcm.abreTela("CadastroFornecedor");
        });
        miCadastrarRecebimento.setOnAction(event ->{
        tcm.abreTela("Pedidos");
        });
        miCadastrarResiduos.setOnAction(event ->{
        tcm.abreTela("CadastroLixo");
        });
        miListarFornecedor.setOnAction(event ->{
        tcm.abreTela("MostrarFornecedor");
        });
        miListagemResiduos.setOnAction(event ->{
        tcm.abreTela("MostraLixo");
        });
        miListagemRecebimento.setOnAction(event ->{
        tcm.abreTela("MostraPedidos");
        });
        miCadastrarTransportador.setOnAction(event ->{
        tcm.abreTela("CadastraTransportador");
        });
        miListarTransportador.setOnAction(event ->{
        tcm.abreTela("MostraTransportadora");
        });
        btnLogout.setOnMouseClicked(event ->{
             Stage stage = (Stage) btnLogout.getScene().getWindow();
    // do what you have to do
            stage.close();
        });
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acaoDosBotoes();
    }    
    
}
