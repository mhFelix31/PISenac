/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete;

import controller.FXMLStartUPController;
import controller.FXMLadminController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author mateus.felix
 */

public class Lanchonete extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(FXMLadminController.class.getResource("/View/FXMLadmin.fxml"));
        loader.setLocation(FXMLStartUPController.class.getResource("/View/FXMLStartUP.fxml"));
        Parent root = loader.load(); 
        
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
    
      
   
    
    
    
}
