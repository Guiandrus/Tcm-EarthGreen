/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conta;
import Model.Pedido;
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
public class PedidoDAO {
    
    public ObservableList<Pedido> select(){
        
        ObservableList<Pedido> pedidos = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM pedido";
        
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Pedido pedido = new Pedido();
                
                
                pedido.setTipoResiduo(rs.getString("tiporesiduo"));
                pedido.setData(rs.getString("dataentrega"));
                pedido.setCnpjFornecedor(rs.getString("cnpjFornecedor"));
                pedido.setCnpjTransportadora(rs.getString("cnpjTransportadora"));
                pedido.setId_pedido(rs.getInt("id_pedido"));

                
                pedidos.add(pedido);
                
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return pedidos;
        
    }
    
    public void insert (Pedido pedido){
    
        String sql = "INSERT INTO pedido (tipoResiduo, dataEntrega, cnpjFornecedor, cnpjTransportadora)" +
                     "VALUES (?, ?, ?, ?)";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        try {
            
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, pedido.getTipoResiduo());
            stmt.setString(2, pedido.getData());
            stmt.setString(3, pedido.getCnpjFornecedor());
            stmt.setString(4, pedido.getCnpjTransportadora());

            
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void delete (Pedido pedido){
            
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";
        
        ConnectionFactory con = new ConnectionFactory();
        
        PreparedStatement stmt;
        
            try {
                
                stmt = con.getConnection().prepareStatement(sql);
                
                stmt.setInt(1, pedido.getId_pedido());
                
                stmt.execute();
                
                stmt.close();
            } catch (Exception e) {
                
            }
            
        }
        
        public void update (Pedido pedido){
            
            String sql = "UPDATE pedido SET cnpjFornecedor = ?, tipoResiduo = ?, cnpjTransportadora = ?, data = ? where id_pedido = ?";
            
            ConnectionFactory con = new ConnectionFactory();
            
            PreparedStatement stmt;
            
            try {
                
            stmt = con.getConnection().prepareStatement(sql);
            
            stmt.setString(1, pedido.getCnpjFornecedor());
            stmt.setString(2, pedido.getTipoResiduo());
            stmt.setString(3, pedido.getCnpjTransportadora());
            stmt.setString(4, pedido.getData());
            stmt.setInt(5, pedido.getId_pedido());
            
            
            
            stmt.execute();
            
                
            } catch (Exception e) {
                System.out.println("Erro : "+e.getLocalizedMessage());
            }
        
            
        }
            
            
        
    
    public static Pedido pedido;
}
