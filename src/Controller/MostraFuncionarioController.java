
package Controller;

import Model.Conta;
import Model.DAO.ContaDAO;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


public class MostraFuncionarioController implements Initializable {

    
    private ObservableList OBListContas;
    @FXML
    private TableColumn<Conta, String> tvEmail;

    @FXML
    private Text Funcionarios;
    
    @FXML
    private TableView<Conta> Tabela;

    @FXML
    private TableColumn<Conta, String> tvLogin;

    @FXML
    private TableColumn<Conta, String> tvtipoConta;

    @FXML
    private TableColumn<Conta, String> tvSenha;

    @FXML
    private TableColumn<Conta, String> tvNome;
    
    @FXML
    private Button btnAtualizar;
    
    @FXML
    private Button btnExcluir;
    
    @FXML
    private Button btnAlterar;
    
    private static Conta selecionado;
    
   public static Conta logada;
    
    ContaDAO contaDAO = new ContaDAO();
    
    public static Conta getContaSelecionada(){
        return selecionado;
    }
    
    public void acaoDosBotoes(){
        
            btnAtualizar.setOnMouseClicked(event ->{
            atualizaTabela();
            });
            
            btnExcluir.setOnMouseClicked(event ->{
            deletar();
            });
            
            btnAlterar.setOnMouseClicked(event ->{
                TCM tcm = new TCM();
                tcm.abreTela("AlterarContas");
            });
        
    }
    
    public void iniciaTabela(){
        
        tvNome.setCellValueFactory(new PropertyValueFactory("nome"));
            tvLogin.setCellValueFactory(new PropertyValueFactory("login"));
            tvEmail.setCellValueFactory(new PropertyValueFactory("email"));
            tvSenha.setCellValueFactory(new PropertyValueFactory("senha"));
            tvtipoConta.setCellValueFactory(new PropertyValueFactory("tipoConta"));
            
        OBListContas = contaDAO.select();
        Tabela.setItems(OBListContas);
        
        OBListContas = contaDAO.select();
        Tabela.setItems(OBListContas);
    }
    public void atualizaTabela(){
        
            
            
        OBListContas = contaDAO.select();
        Tabela.setItems(OBListContas);
       

    }
    
    public void deletar(){
        
        try{
         if (selecionado != null) {
                
                contaDAO.delete(selecionado);
                
            } else {
             
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setHeaderText("Selecione uma conta!");
                al.show();
                
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    iniciaTabela();
    
    acaoDosBotoes();
    
    tvNome.setStyle("");
    Tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Conta) newValue;
            }
            });
    }    
    
}
