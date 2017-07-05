/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.DAO.FornecedorDAO;
import Model.DAO.PedidoDAO;
import Model.DAO.TransportadorDAO;
import Model.Fornecedor;
import Model.Pedido;
import Model.Transportadora;
import View.manage.TCM;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class MostraPedidosController implements Initializable {

        @FXML
    private TableColumn<Transportadora, String> tvTransportadora;

    @FXML
    private DatePicker dateData;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<Fornecedor, String> tvFornecedor;

    @FXML
    private TableColumn<Pedido, String> tvTipo;
    
    @FXML
    private TableView<Pedido> tabela;
    
    @FXML
    private TableColumn<Pedido, String> tvData;
    
    public Pedido selecionado;

    @FXML
    private Button btnAtualizar;
    
    ObservableList<Pedido> OBListPedidos;
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    TransportadorDAO transportadorDAO = new TransportadorDAO();
    PedidoDAO pedidoDAO = new PedidoDAO();
    
    @FXML
    private Button btnPesquisar;
    
    public void acaoDosBotoes(){
        btnAtualizar.setOnMouseClicked(event ->{
        atualizaTabela();
        });
        btnExcluir.setOnMouseClicked(event ->{
        deletar();
        });
        btnPesquisar.setOnMouseClicked(event ->{
        tabela.setItems(busca());
        });
        
    }
    
    public void iniciaTabela(){
        
            tvFornecedor.setCellValueFactory(new PropertyValueFactory("cnpjFornecedor"));
            tvTipo.setCellValueFactory(new PropertyValueFactory("tipoResiduo"));
            tvTransportadora.setCellValueFactory(new PropertyValueFactory("cnpjTransportadora"));
            tvData.setCellValueFactory(new PropertyValueFactory("data"));
         
            
        OBListPedidos = pedidoDAO.select();
        tabela.setItems(OBListPedidos);
        
        OBListPedidos = pedidoDAO.select();
        tabela.setItems(OBListPedidos);
    }
    public void atualizaTabela(){
        
            
            
        OBListPedidos = pedidoDAO.select();
        tabela.setItems(OBListPedidos);
       

    }
    
    public void deletar(){
        
        try{
         if (selecionado != null) {
                Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deseja mesmo cancelar esse pedido?");
            alert.setHeaderText(null);
            alert.setContentText("Caso o pedido seja cancelado essa ação não pode ser desfeita.");
            
            
            alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
            pedidoDAO.delete(selecionado);   
            }
             });
            
                
                
            } else {
             
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setHeaderText("Selecione um pedido!");
                al.show();
                
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public ObservableList<Pedido> busca(){
        ObservableList<Pedido> pesquisaPedido = FXCollections.observableArrayList();
        for (int i = 0; i < OBListPedidos.size(); i++) {
            if (OBListPedidos.get(i).getData().toLowerCase().contains(String.valueOf(dateData.getValue()))) {
                pesquisaPedido.add(OBListPedidos.get(i));
            }
            
        }
        return pesquisaPedido;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        acaoDosBotoes();
        iniciaTabela();
            tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Pedido) newValue;
            }
            });
            
    }    
    }    
    

