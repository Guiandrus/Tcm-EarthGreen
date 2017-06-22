/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PDF;
import View.manage.TCM;
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
    private MenuItem cadContas;

    @FXML
    private MenuItem cadTransportadora;

    @FXML
    private MenuItem cadResiduo;

    @FXML
    private MenuItem miResiduos;

    @FXML
    private MenuItem cadFornecedor;

    @FXML
    private MenuItem miFuncionario;

    @FXML
    private Button btnInfo;

    PDF pdf = new PDF();
    
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
         cadContas.setOnAction(event ->{
             tcm.abreTela("Cadastro");
         });
         cadFornecedor.setOnAction(event ->{
             tcm.abreTela("CadastroFornecedor");
         });
         cadResiduo.setOnAction(event ->{
             tcm.abreTela("CadastroLixo");
         });
         cadTransportadora.setOnAction(event ->{
             tcm.abreTela("CadastraTransportador");
         });
         btnInfo.setOnAction(event ->{
         pdf.abrePDF();
         });
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        acaoDosBotoes();
        pdf.criaPDF();
        
    }    
    
}
