/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aluno
 */
public class Transportadora {
    
    String nome;
    String telefone;
    String email;
    String cnpj;
    String tipoDeLixo;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipoDeLixo() {
        return tipoDeLixo;
    }

    public void setTipoDeLixo(String tipoDeLixo) {
        this.tipoDeLixo = tipoDeLixo;
    }

    @Override
    public String toString() {
        return "Transportadora: "+nome;
    }
    
    
    
    
}
