/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lanchonete.SqlHandler;

/**
 * FXML Controller class
 *
 * @author mHF
 */
public class FXMLStartUPController implements Initializable {

    @FXML
    private Group InicialGroup;
    @FXML
    private Group loginGroup;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Label incorrectWarningLabel;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void TotemAction(ActionEvent event) {
    }

    @FXML
    private void CozinhaAction(ActionEvent event) {
    }

    @FXML
    private void AdminAction(ActionEvent event) {
        InicialGroup.setVisible(false);
        loginGroup.setVisible(true);
    }
    
    private SqlHandler sql = new SqlHandler();
    @FXML
    private void enterButton(ActionEvent event)throws Exception {
        String curLogin = login.getText();
        String curPassword = password.getText();
        Connection conn = sql.Connect("localhost","3306","lanchonete",curLogin,curPassword);
        if (conn != null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FXMLadminController.class.getResource("/View/FXMLadmin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else {
            incorrectWarningLabel.setVisible(true);
        }
        
        
        
    }

    
    
    @FXML
    private void voltarButton(ActionEvent event) {
        InicialGroup.setVisible(true);
        loginGroup.setVisible(false);
        //incorrectWarningLabel.setVisible(false);
        
    }
    
}
