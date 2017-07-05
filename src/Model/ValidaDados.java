/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Aluno  
 */
public class ValidaDados {
    
        public boolean validaemail(String email){
            
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(email);
        if(m.find() && m.group().equals(email)){
            return true;
        } else {
            Alert alert = new Alert (AlertType.WARNING);
            alert.setTitle("Email invalido");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite um email valido");
            alert.showAndWait();
            
            return false;
        }
                
    }
        
        public boolean validaTelefone(Fornecedor fornecedor){
            Pattern p = Pattern.compile("*([0-9]*)[0-9]*-[0-9]");
            Matcher m = p.matcher(fornecedor.getTelefone());
            if(m.find() && m.group().equals(fornecedor.getTelefone())){
            return true;
        } else {
            Alert alert = new Alert (AlertType.WARNING);
            alert.setTitle("telefone invalido");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite um telefone valido");
            alert.showAndWait();
            return false;
        }
        }
}
