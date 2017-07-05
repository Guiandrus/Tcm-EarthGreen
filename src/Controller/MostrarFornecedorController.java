
package Controller;


import Model.Conta;
import Model.DAO.FornecedorDAO;
import Model.Fornecedor;
import View.manage.TCM;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class MostrarFornecedorController implements Initializable {

    
    private ObservableList OBListFornecedor;
    @FXML
    private TableView<Fornecedor> tabela;
            
    @FXML
    private TableColumn<Fornecedor, String> tvEmail;

    @FXML
    private TableColumn<Fornecedor, String> tvTelefone;
    
    @FXML
    private TableColumn<Fornecedor, String> tvCnpj;

    @FXML
    private TableColumn<Fornecedor, String> tvNome;
    
    @FXML
    private Button btnEditar;

    @FXML
    private Button btnAtualizar;
    
    @FXML
    private Button btnExcluir;
    
    public static Fornecedor selecionado;
    
    public static Fornecedor getFornecedorSelecionado(){
        return selecionado;
    }
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
     public void acaoDosBotoes(){
            
       
            btnAtualizar.setOnMouseClicked(event ->{
            atualizaTabela();
            
            });
            
            btnExcluir.setOnMouseClicked(event ->{
            deletar();
            });
            
            btnEditar.setOnMouseClicked(event ->{
                try {
                    
                    TCM tcm = new TCM();
                    tcm.abreTela("AlterarFornecedor");
                    
                } catch (Exception e) {
                    System.out.println("Erro : "+e.getLocalizedMessage());
                }
                
                
                
            });
        
    }
    
    public void iniciaTabela(){
        
        
            tvNome.setCellValueFactory(new PropertyValueFactory("empresa"));
            tvEmail.setCellValueFactory(new PropertyValueFactory("email"));
            tvTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
            tvCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
            
            
        OBListFornecedor = fornecedorDAO.select();
        tabela.setItems(OBListFornecedor);
        
        OBListFornecedor = fornecedorDAO.select();
        tabela.setItems(OBListFornecedor);
    }
    public void atualizaTabela(){
        
            
            
        OBListFornecedor = fornecedorDAO.select();
        tabela.setItems(OBListFornecedor);
       

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
            fornecedorDAO.delete(selecionado);  
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

    public static Fornecedor getConta(){
        return selecionado;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    iniciaTabela();
    
    acaoDosBotoes();
    
    tvNome.setStyle("");
    
    tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Fornecedor) newValue;
                
            }
            });
    }

      
    
}
