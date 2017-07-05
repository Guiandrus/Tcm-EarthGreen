package Controller;

import static Controller.MostrarFornecedorController.selecionado;
import Model.Conta;
import Model.DAO.LixoDAO;
import Model.Fornecedor;
import Model.Lixo;
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


public class MostraLixoController implements Initializable {

    
    @FXML
    private TableColumn<Lixo, String> tcQtdLixo;

    @FXML
    private TableView<Lixo> tabela;

    @FXML
    private TableColumn<Lixo, String> tcIID;

    @FXML
    private TableColumn<Lixo, String> tcTipoLixo;

    @FXML
    private Button btnExcluir;

    ObservableList<Lixo> lixo;

    @FXML
    private Button btnEditar;

    @FXML
    private TextField tfPesquisa;
    
    @FXML
    private Button btnAtualizar;
    
    public static Lixo selecionado;

    public static Lixo getLixoSelecionado() {
        return selecionado;
    }
    
    public ObservableList<Lixo> getLixo(){
        lixo = DAO.select();
        return lixo;
    }

    LixoDAO DAO = new LixoDAO();
    
    public void acaoDosBotoes(){
        btnAtualizar.setOnMouseClicked(event ->{
        
        atualizaTabela();
            
        });
        
        btnExcluir.setOnMouseClicked(event ->{
        deletar();
        });
        
        btnEditar.setOnMouseClicked(event ->{
            TCM tcm = new TCM();
            tcm.abreTela("AlteraResiduos");
        });
        tfPesquisa.setOnKeyTyped(event ->{
        tabela.setItems(busca());
        });
    }
    
    public ObservableList<Lixo> busca(){
        ObservableList<Lixo> pesquisaLixo = FXCollections.observableArrayList();
        for (int i = 0; i < lixo.size(); i++) {
            if (lixo.get(i).getNome().toLowerCase().contains(tfPesquisa.getText())) {
                pesquisaLixo.add(lixo.get(i));
            }
            
        }
        return pesquisaLixo;
    }
    
    public void iniciaTabela(){
        
        
            tcTipoLixo.setCellValueFactory(new PropertyValueFactory("tipo"));
            tcQtdLixo.setCellValueFactory(new PropertyValueFactory("toneladas"));
            tcIID.setCellValueFactory(new PropertyValueFactory("nome"));
            

            
        lixo = DAO.select();
        tabela.setItems(lixo);
        
        lixo = DAO.select();
        tabela.setItems(lixo);
        
        
        System.out.println("Nome:"+lixo.get(0).getNome());
        System.out.println("Tipo:"+lixo.get(0).getTipo());
        System.out.println("Qtd"+lixo.get(0).getToneladas());
    }
    public void atualizaTabela(){
        
            
            
        lixo = DAO.select();
        tabela.setItems(lixo);
       

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciaTabela();
        atualizaTabela();
        acaoDosBotoes();
        
        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Lixo) newValue;
                
            }
            });
    }    
    
}
