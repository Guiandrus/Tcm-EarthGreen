/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.manage;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aluno
 */
public class TCM extends Application {
    
    String tela = "Login";
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/"+tela+".fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void abreTela(String nomeTela){
        tela = nomeTela;
        Stage stage = new Stage();
        try {
            start(stage);
        } catch (Exception ex) {
            Logger.getLogger(TCM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
    

