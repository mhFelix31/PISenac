/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lanchonete.generic.genericObj;

/**
 * FXML Controller class
 *
 * @author mHF
 */
public class FXMLTabelaReceitaController implements Initializable {

    @FXML
    private TextField receita_field_id;
    @FXML
    private TextField receita_field_idProduto;
    @FXML
    private TextField receita_field_quantidade;
    @FXML
    private Button receita_button_editar;
    @FXML
    private Button deleteButton;
    

    public FXMLadminController MainScreen;
    private genericObj gO;
    public void setGo(genericObj gO){
        this.gO = gO;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    
    @FXML
    private void edit(ActionEvent event) {
    }

    @FXML
    private void DELETEPress(ActionEvent event) {
    }
    
}
