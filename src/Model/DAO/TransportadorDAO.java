/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conta;
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
public class TransportadorDAO {
    
        
    
    public ObservableList<Transportadora> select(){
        
        ObservableList<Transportadora> transportadora = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM transportadora";
        
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Transportadora transporte = new Transportadora();
                
                
                transporte.setEmail(rs.getString("email"));
                transporte.setCnpj(rs.getString("cnpj"));
                transporte.setTelefone(rs.getString("telefone"));
                transporte.setNome(rs.getString("nome"));
                transporte.setTipoDeLixo(rs.getString("tipoDeLixo"));
                
                transportadora.add(transporte);
                
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return transportadora;
        
    }
    
    public void insert (Transportadora transportadora){
    
        String sql = "INSERT INTO transportadora (nome, email, cnpj, telefone, tipoDeLixo)" +
                     "VALUES (?, ?, ?, ?, ?)";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        try {
            
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, transportadora.getNome());
            stmt.setString(2, transportadora.getEmail());
            stmt.setString(3, transportadora.getCnpj());
            stmt.setString(4, transportadora.getTelefone());
            stmt.setString(5, transportadora.getTipoDeLixo());
            
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void delete (Transportadora transportadora){
            
        String sql = "DELETE FROM conta WHERE ID = ?";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        
            try {
                
                stmt = con.getConnection().prepareStatement(sql);
                
                stmt.setInt(1, transportadora.getId());
                
            } catch (Exception e) {
                
            }
            
        }
        
        public void update (Transportadora transportadora){
            
            String sql = "UPDATE conta SET nome = ?, cnpj = ?, email = ?, telefone = ?, tipoDeLixo = ? FROM usuario where ID = ?";
            
            ConnectionFactory con = new ConnectionFactory();
            
            PreparedStatement stmt;
            
            try {
                
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, transportadora.getNome());
            stmt.setString(3, transportadora.getCnpj());
            stmt.setString(2, transportadora.getEmail());
            stmt.setString(4, transportadora.getTelefone());
            stmt.setString(5, transportadora.getTipoDeLixo());
            stmt.setInt(6, transportadora.getId());
            
            stmt.execute();
            
                
            } catch (Exception e) {
                
            }
        
            
        }
            
            
        
    
    static int contaLogada;
    private static ObservableList<Transportadora> listaDeTransportadoras = FXCollections.observableArrayList();
    
    
    public ObservableList<Transportadora> getConta(){
        return listaDeTransportadoras;
    }
    
    public int contaLogada(){
        int contaLogadaAgora = contaLogada;
        return contaLogadaAgora;
    }
    
}
