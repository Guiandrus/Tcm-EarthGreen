/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.FornecedorDAO;
import static java.util.Collections.list;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Aluno
 */
public class Fornecedor {
    FornecedorDAO DAO = new FornecedorDAO();
    ObservableList<Fornecedor> listFornecedores = FXCollections.observableArrayList();
    
    int id;
    
    String telefone;
    String empresa;
    String cnpj;
    String email;

    public ObservableList<Fornecedor> addFornecedores(){
         listFornecedores = DAO.select();
         return listFornecedores;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String toString() {
        
        return "Fornecedor: "+empresa;
        
        
    }
    
}
