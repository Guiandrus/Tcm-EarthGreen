/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.FornecedorDAO;
import Model.DAO.PedidoDAO;
import Model.DAO.TransportadorDAO;
import Model.Fornecedor;
import Model.Lixo;
import Model.Pedido;
import Model.Transportadora;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class PedidosController implements Initializable {

    @FXML
    private Button btnConfirmar;

    @FXML
    private ComboBox<String> comboResíduo;

    @FXML
    private ComboBox<Fornecedor> comboFornecedor;

    @FXML
    private ComboBox<Transportadora> comboTransporte;

    @FXML
    private DatePicker data;
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    TransportadorDAO transportadorDAO = new TransportadorDAO();
    public void atualizaComboBox(){
    
    comboFornecedor.setItems(fornecedorDAO.select());
    
    comboTransporte.setItems(transportadorDAO.select());
    
    ObservableList<String> tipoMaterial = FXCollections.observableArrayList();
    tipoMaterial.addAll("Metal", "Reciclavel", "Vidro", "Organico", "Hospitalar", "Nuclear", "Plastico");
    comboResíduo.setItems(tipoMaterial);
    }
    
    
    public void acaoDosBotoes(){
        
        btnConfirmar.setOnMouseClicked(event ->{
            Pedido pedido = new Pedido();
            pedido.setCnpjFornecedor(comboFornecedor.getValue().getEmpresa());
            pedido.setCnpjTransportadora(comboTransporte.getValue().getNome());
            pedido.setTipoResiduo(comboResíduo.getValue());
            pedido.setData(String.valueOf(data.getValue()));
            PedidoDAO DAO = new PedidoDAO();
            DAO.insert(pedido);
        });
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        atualizaComboBox();
        acaoDosBotoes();
        
    }    
    
}
