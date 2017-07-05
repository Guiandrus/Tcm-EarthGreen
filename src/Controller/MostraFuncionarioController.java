
package Controller;

import Model.Conta;
import Model.DAO.ContaDAO;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


public class MostraFuncionarioController implements Initializable {

    
    private ObservableList<Conta> OBListContas;
    
    @FXML
    private TextField tfPesquisa;

    @FXML
    private Button btnIr;
    
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
            tfPesquisa.setOnKeyTyped(event ->{
            Tabela.setItems(busca());
            });
            btnIr.setOnMouseClicked(event ->{
                Tabela.setItems(busca());
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
                Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deseja mesmo excluir esse usuário?");
            alert.setHeaderText(null);
            alert.setContentText("Caso o usuário seja excluido essa ação não pode ser desfeita.");
            
            
            alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
            contaDAO.delete(selecionado);   
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
    
    public ObservableList<Conta> busca(){
        ObservableList<Conta> pesquisaConta = FXCollections.observableArrayList();
        for (int i = 0; i < OBListContas.size(); i++) {
            if (OBListContas.get(i).getNome().toLowerCase().contains(tfPesquisa.getText())) {
                pesquisaConta.add(OBListContas.get(i));
            }
            
        }
        return pesquisaConta;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    iniciaTabela();
    
    acaoDosBotoes();
    
    Tooltip teste = new Tooltip("Serve para alterar os dados");
    
    btnAlterar.setOnMouseEntered(event ->{
        teste.setText("Serve para alterar os dados");
        teste.setStyle("-fx-border-color: WHITE;"
                + "-fx-font-color: RED");
        btnAlterar.setTooltip(teste);
    });
    
    btnExcluir.setOnMouseEntered(event ->{
        teste.setText("Serve para excluir os dados");
        btnExcluir.setTooltip(teste);
    });
    
    tvNome.setStyle("");
    
    Tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Conta) newValue;
            }
            });
    }    
    
}
