/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.LixoDAO;
import Model.DAO.PedidoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class GraficoLinhaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private LineChart<String, Number> IDGraficoLinha;
    XYChart.Series series = new XYChart.Series();
    PedidoDAO pedidoDAO = new PedidoDAO();
    LixoDAO lixoDAO = new LixoDAO();
    
    public void iniciaGrafico(){
        IDGraficoLinha.setTitle("Resíduos");
        //defining a series
        
        series.setName("Monitoramento de resíduos");
        //populating the series with data
        for (int i = 0; i < lixoDAO.select().size(); i++) {
            
           series.getData().add(new XYChart.Data(lixoDAO.select().get(i).getTipo(), Double.valueOf(lixoDAO.select().get(i).getToneladas())));
           
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        iniciaGrafico();
        IDGraficoLinha.getData().add(series);
    }    
    
}
