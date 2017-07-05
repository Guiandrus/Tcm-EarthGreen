/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conta;
import Model.Fornecedor;
import Model.Lixo;
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
public class LixoDAO {
    public ObservableList<Lixo> select(){
        
        ObservableList<Lixo> lixo = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM lixo";
        
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Lixo residuo = new Lixo();
                
                
                residuo.setTipo(rs.getString("tipodoresiduo"));
                residuo.setToneladas(rs.getDouble("quantidade"));
                residuo.setNome(rs.getString("nome"));
                residuo.setId(rs.getInt("id_residuo"));
                
                
                
                lixo.add(residuo);
                
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return lixo;
        
    }
    
    public void insert (Lixo lixo){
    
        String sql = "INSERT INTO lixo (tipoDoResiduo, Quantidade, nome)" +
                     "VALUES (?, ?, ?)";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        try {
            
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, lixo.getTipo());
            stmt.setDouble(2, lixo.getToneladas());
            stmt.setString(3, lixo.getNome());
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro : "+ex.getLocalizedMessage());
        }
        
    }
        public void delete (Lixo lixo){
            
        String sql = "DELETE FROM lixo WHERE id_residuo = ?";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        
            try {
                
                stmt = con.getConnection().prepareStatement(sql);
                
                stmt.setInt(1, lixo.getId());
                
                stmt.execute();
                
                stmt.close();
            } catch (Exception e) {
                System.out.println("erro : "+e.getLocalizedMessage());
            }
            
        }
        
        public void update (Lixo lixo){
            
            String sql = "UPDATE lixo SET tipoDoResiduo = ?, quantidade = ? where nome = ?";
            
            ConnectionFactory con = new ConnectionFactory();
            
            PreparedStatement stmt;
            
            try {
                
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, lixo.getTipo());
            stmt.setDouble(2, lixo.getToneladas());
            stmt.setString(3, lixo.getNome());
                      
            stmt.execute();
            
                
            } catch (Exception e) {
                System.out.println("Erro : "+e.getLocalizedMessage());
            }
        
            
        }   
}
