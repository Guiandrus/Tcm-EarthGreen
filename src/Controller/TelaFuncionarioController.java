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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author Leo
 */
public class TelaFuncionarioController implements Initializable {

    
    @FXML
    private MenuItem miCadastrarFornecedor;

    @FXML
    private MenuItem miListagemRecebimento;

    @FXML
    private MenuItem miListagemResiduos;

    @FXML
    private MenuItem miCadastrarRecebimento;

    @FXML
    private MenuItem miCadastrarResiduos;

    @FXML
    private MenuItem miListarFornecedor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
