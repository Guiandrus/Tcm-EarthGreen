/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Controller.TelaADMController;
import Model.Conta;
import Model.jbdc.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Aluno
 */
public class ContaDAO {
    
    public List<Conta> select(){
        
        List<Conta> contas = new ArrayList();
        
        String sql = "SELECT * FROM usuario";
        
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Conta conta = new Conta();
                
                conta.setId(rs.getInt("id"));
                conta.setEmail(rs.getString("email"));
                conta.setLogin(rs.getString("login"));
                conta.setSenha(rs.getString("senha"));
                conta.setNome(rs.getString("nome"));
                
                contas.add(conta);
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return contas;
        
    }
    
    public void insert (Conta conta){
    
        String sql = "INSERT INTO usuario (nome, email, login, senha)" +
                     "VALUES (?, ?, ?, ?)";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        try {
            
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, conta.getNome());
            stmt.setString(2, conta.getEmail());
            stmt.setString(3, conta.getLogin());
            stmt.setString(4, conta.getSenha());
            
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void delete (Conta conta){
            
        String sql = "DELETE FROM usuario WHERE ID = ?";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        
            try {
                
                stmt = con.getConnection().prepareStatement(sql);
                
                stmt.setInt(1, conta.getId());
                
            } catch (Exception e) {
                
            }
            
        }
        
        public void update (Conta conta){
            
            String sql = "UPDATE usuario SET nome = ?, login = ?, email = ?, senha = ? FROM usuario where ID = ?";
            
            ConnectionFactory con = new ConnectionFactory();
            
            PreparedStatement stmt;
            
            try {
                
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, conta.getNome());
            stmt.setString(3, conta.getEmail());
            stmt.setString(2, conta.getLogin());
            stmt.setString(4, conta.getSenha());
            stmt.setInt(5, conta.getId());
            
            stmt.execute();
            
                
            } catch (Exception e) {
                
            }
        
            
        }
            
            
        
    
    static int contaLogada;
    TelaADMController telaADM = new TelaADMController();
    private static ObservableList<Conta> listaDeContas = FXCollections.observableArrayList();
    
    
    public static ObservableList<Conta> getConta(){
        return listaDeContas;
    }
    
    public int contaLogada(){
        int contaLogadaAgora = contaLogada;
        return contaLogadaAgora;
    }
}
