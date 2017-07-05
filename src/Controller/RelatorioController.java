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
import javafx.scene.control.MenuItem;
import model.PDF;


/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class RelatorioController implements Initializable {
    
    
    
    @FXML
    private MenuItem miPieChart;

    @FXML
    private MenuItem miGerarPDF;

    @FXML
    private MenuItem miLineChart;
    
    TCM tcm = new TCM();
    
    public void acaoDosBotoes(){
        
        miPieChart.setOnAction(event ->{
        tcm.abreTela("Pizza");
        });
        miGerarPDF.setOnAction(event ->{
        PDF pdf = new PDF();
        pdf.gerarPdf();
        });
        miLineChart.setOnAction(event ->{
        tcm.abreTela("GraficoLinha");
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acaoDosBotoes();
    }    
    
}
