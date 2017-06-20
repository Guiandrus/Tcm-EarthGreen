/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TCM;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author Leo
 */
public class TelaADMController implements Initializable {

    
    @FXML
    private MenuItem miFornecedor;

    @FXML
    private MenuItem miTransportadora;

    @FXML
    private MenuItem miResiduos;

    @FXML
    private MenuItem miFuncionario;

    @FXML
    private Button btnInfo;
    TCM tcm = new TCM();
    
    public void acaoDosBotoes(){
         miFornecedor.setOnAction(event ->{
             tcm.abreTela("MostrarFornecedor");
         });
         miTransportadora.setOnAction(event ->{
             tcm.abreTela("Mos traTransportador");
         });
         miFuncionario.setOnAction(event ->{
             tcm.abreTela("MostraFuncionario");
         });
         miResiduos.setOnAction(event ->{
             tcm.abreTela("MostraLixo");
         });
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acaoDosBotoes();
    }    
    
}
