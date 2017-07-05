/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.DAO.TransportadorDAO;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class MostraTranportadoraController implements Initializable {

    @FXML
    private TextField tfPesquisa;
    
    @FXML
    private TableView<Transportadora> tabela;

    @FXML
    private TableColumn<Transportadora, String> tvContato;

    @FXML
    private TableColumn<Transportadora, String> tvCnpj;

    @FXML
    private TableColumn<Transportadora, String> tvMaterial;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<Transportadora, String> tvNome;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnAtualizar;
    
    private static Transportadora selecionado;
    
    TransportadorDAO DAO = new TransportadorDAO();

    public static Transportadora getSelecionado() {
        return selecionado;
    }

    public static void setSelecionado(Transportadora selecionado) {
        MostraTranportadoraController.selecionado = selecionado;
    }

    
    
    ObservableList<Transportadora> transp;
    public void iniciaTabela(){
        
        tvNome.setCellValueFactory(new PropertyValueFactory("nome"));
            tvCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
            tvContato.setCellValueFactory(new PropertyValueFactory("email"));
            tvMaterial.setCellValueFactory(new PropertyValueFactory("tipoDeLixo"));
            
            
        transp = DAO.select();
        tabela.setItems(transp);
        
        transp = DAO.select();
        tabela.setItems(transp);
    }
    
    public void acaoDosBotoes(){
        
            btnAtualizar.setOnMouseClicked(event ->{
            atualizaTabela();
            });
            
            btnExcluir.setOnMouseClicked(event ->{
            deletar();
            });
            
            btnEditar.setOnMouseClicked(event ->{
                TCM tcm = new TCM();
                tcm.abreTela("AlterarTransportador");
            });
            tfPesquisa.setOnKeyTyped(event ->{
                tabela.setItems(busca());
            });
        
    }
    
    public ObservableList<Transportadora> busca(){
        ObservableList<Transportadora> pesquisaTransportadora = FXCollections.observableArrayList();
        for (int i = 0; i < transp.size(); i++) {
            if (transp.get(i).getNome().toLowerCase().contains(tfPesquisa.getText())) {
                pesquisaTransportadora.add(transp.get(i));
            }
            
        }
        return pesquisaTransportadora;
    }
    
    public void deletar(){
        
        try{
         if (selecionado != null) {
                Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deseja mesmo excluir esse usuário?");
            alert.setHeaderText(null);
            alert.setContentText("Caso o usuário seja excluido essa ação não pode ser desfeita.");
            
            
            alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
            DAO.delete(selecionado);   
            }
             });
            
                
                
            } else {
             
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setHeaderText("Selecione uma conta!");
                al.show();
                
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void atualizaTabela(){
        
            
            
        transp = DAO.select();
        tabela.setItems(transp);
       

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        iniciaTabela();
        
        acaoDosBotoes();
        
        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Transportadora) newValue;
            } 
            });
    }    
    }    
    

