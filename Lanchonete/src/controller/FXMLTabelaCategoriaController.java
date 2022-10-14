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
public class FXMLTabelaCategoriaController implements Initializable {

    @FXML
    private TextField produto_field_id;
    @FXML
    private TextField produto_field_nome;
    @FXML
    private TextField produto_field_image;
    @FXML
    private Button produto_button_editar;
    @FXML
    private Button deleteButton;
    
    public FXMLadminController MainScreen;
    private genericObj gO;
    public void setGo(genericObj gO){
        this.gO = gO;
    }

    
    public void UpdateInfos(){
        produto_field_id.setText(gO.getColunaValue(0)!= null?gO.getColunaValue(0):"");
        produto_field_nome.setText(gO.getColunaValue(1)!= null?gO.getColunaValue(1):"");
        produto_field_image.setText(gO.getColunaValue(2)!= null?gO.getColunaValue(2):"");
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
