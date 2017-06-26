/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Fornecedor;
import Model.Transportadora;
import Model.jbdc.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Aluno
 */
public class FornecedorDAO {
    
    public ObservableList<Fornecedor> select(){
        
        ObservableList<Fornecedor> fornecedores = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM transportadora";
        
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Fornecedor fornecedor = new Fornecedor();
                
                
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmpresa(rs.getString("empresa"));
                fornecedor.setTelefone(rs.getString("telefone"));
                
                fornecedores.add(fornecedor);
                
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return fornecedores;
        
    }
    
    public void insert (Fornecedor fornecedor){
    
        String sql = "INSERT INTO fornecedor (nome, empresa, telefone)" +
                     "VALUES (?, ?, ?)";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        try {
            
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmpresa());
            stmt.setString(3, fornecedor.getTelefone());
            
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void delete (Fornecedor fornecedor){
            
        String sql = "DELETE FROM fornecedor WHERE ID = ?";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        
            try {
                
                stmt = con.getConnection().prepareStatement(sql);
                
                stmt.setInt(1, fornecedor.getId());
                
            } catch (Exception e) {
                
            }
            
        }
        
        public void update (Fornecedor fornecedor){
            
            String sql = "UPDATE conta SET nome = ?, telefone = ?, empresa = ? FROM usuario where ID = ?";
            
            ConnectionFactory con = new ConnectionFactory();
            
            PreparedStatement stmt;
            
            try {
                
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(3, fornecedor.getEmpresa());
            stmt.setString(2, fornecedor.getTelefone());

            stmt.setInt(4, fornecedor.getId());
            
            stmt.execute();
            
                
            } catch (Exception e) {
                
            }
        
            
        }
            
            
        
    
    static int contaLogada;
    private static ObservableList<Fornecedor> listaDeFornecedores = FXCollections.observableArrayList();
    
    
    public ObservableList<Fornecedor> getConta(){
        return listaDeFornecedores;
    }
    
    public int contaLogada(){
        int contaLogadaAgora = contaLogada;
        return contaLogadaAgora;
    }
}
