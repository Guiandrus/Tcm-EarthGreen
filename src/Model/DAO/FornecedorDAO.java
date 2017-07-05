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
        
        String sql = "SELECT * FROM fornecedor";
        
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Fornecedor fornecedor = new Fornecedor();
                 
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCnpj(rs.getString("cnpj"));
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
    
        String sql = "INSERT INTO fornecedor (empresa, telefone, cnpj, email)" +
                     "VALUES (?, ?, ?, ?)";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        try {
            
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, fornecedor.getEmpresa());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getEmail());
            
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void delete (Fornecedor fornecedor){
            
        String sql = "DELETE FROM fornecedor WHERE cnpj = ?";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        
            try {
                
                stmt = con.getConnection().prepareStatement(sql);
                
                stmt.setString(1, fornecedor.getCnpj());
                
                stmt.execute();
            } catch (Exception e) {
                
            }
            
        }
        
        public void update (Fornecedor fornecedor){
            
            String sql = "UPDATE fornecedor SET empresa = ?, telefone = ?, email = ? where cnpj = ?";
            
            ConnectionFactory con = new ConnectionFactory();
            
            PreparedStatement stmt;
            
            try {
                
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, fornecedor.getEmpresa());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(2, fornecedor.getTelefone());

            stmt.setString(4, fornecedor.getCnpj());
            
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
