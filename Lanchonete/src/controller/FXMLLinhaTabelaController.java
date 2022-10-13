/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mHF
 */
public class FXMLLinhaTabelaController implements Initializable {

    @FXML
    private MenuButton menu_produto_categoria;
    @FXML
    private TextField produto_field_image;
    @FXML
    private TextField produto_field_nome;
    @FXML
    private Button produto_button_editar;
    @FXML
    private MenuButton menu_produto_tipocobranca;
    @FXML
    private TextField produto_field_id;
    @FXML
    private TextField produto_field_preco;
    @FXML
    private TextField produto_field_descricao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
