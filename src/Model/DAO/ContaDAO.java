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
    
    
    public ObservableList<Conta> select(){
        
        ObservableList<Conta> contas = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM conta";
        
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Conta conta = new Conta();
                
                
                conta.setEmail(rs.getString("email"));
                conta.setLogin(rs.getString("login"));
                conta.setSenha(rs.getString("senha"));
                conta.setNome(rs.getString("nome"));
                conta.setTipoConta(rs.getString("tipoConta"));
                conta.setCaminhoimagem(rs.getString("caminhodaimagem"));
                
                contas.add(conta);
                
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return contas;
        
    }
    
    public void insert (Conta conta){
    
        String sql = "INSERT INTO conta (nome, email, login, senha, tipoConta, caminhodaimagem)" +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        try {
            
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, conta.getNome());
            stmt.setString(2, conta.getEmail());
            stmt.setString(3, conta.getLogin());
            stmt.setString(4, conta.getSenha());
            stmt.setString(5, conta.getTipoConta());
            stmt.setString(6, conta.getCaminhoimagem());
            
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void delete (Conta conta){
            
        String sql = "DELETE FROM conta WHERE login = ?";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        
            try {
                
                stmt = con.getConnection().prepareStatement(sql);
                
                stmt.setString(1, conta.getLogin());
                
                stmt.execute();
                
                stmt.close();
            } catch (Exception e) {
                
            }
            
        }
        
        public void update (Conta conta){
            
            String sql = "UPDATE conta SET nome = ?, email = ?, senha = ? where login = ?";
            
            ConnectionFactory con = new ConnectionFactory();
            
            PreparedStatement stmt;
            
            try {
                
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, conta.getNome());
            stmt.setString(2, conta.getEmail());
            stmt.setString(3, conta.getSenha());
            stmt.setString(4, conta.getLogin());
            
            
            
            stmt.execute();
            
                
            } catch (Exception e) {
                System.out.println("Erro : "+e.getLocalizedMessage());
            }
        
            
        }
            
            
        
    
    public static Conta contalogada;
}
