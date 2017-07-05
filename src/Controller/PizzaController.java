/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.LixoDAO;
import Model.Lixo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class PizzaController implements Initializable {
    public ObservableList<Lixo> lixo;

    LixoDAO DAO = new LixoDAO();
    public ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    
    @FXML
    private PieChart pieChart;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lixo = DAO.select();
        
            for (int i = 0; i < lixo.size(); i++) {
                data.add(                
                new PieChart.Data(lixo.get(i).getNome()+" "+lixo.get(i).getToneladas(), lixo.get(i).getToneladas())
                        
        );  
        }
        
        pieChart.setData(data);
        pieChart.setTitle("Resíduos cadastrados no estoque (Em Toneladas)");
        pieChart.setLegendSide(Side.BOTTOM);
    }    
    
}
