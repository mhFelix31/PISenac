/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import model.ListaPrincipal;
import model.ListaPrincipal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asdfq
 */
public class FXMLItemListMainController implements Initializable {
    
    @FXML 
    private Button bntObs;
    @FXML
    private ImageView imageItemMain;
    @FXML
    private AnchorPane root;
    private ListaPrincipal model;
    private String nome;

    /**
     * Initializes the controller class.
     * @param Nome
     */
    
    
    
    public FXMLItemListMainController(String Nome) {
        this.nome = Nome;
     }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bntObs.setText(nome);
    }
}
