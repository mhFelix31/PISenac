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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import lanchonete.generic.genericObj;

/**
 * FXML Controller class
 *
 * @author mHF
 */
public class FXMLTabelaPedidoController implements Initializable {

    @FXML
    private TextField pedido_field_id;
    @FXML
    private TextField pedido_field_valorTotal;
    @FXML
    private TextField pedido_field_funcionario;
    @FXML
    private TextField pedido__field_cliente;
    @FXML
    private MenuButton pedido_menu_status;
    @FXML
    private Button produto_button_editar;
    @FXML
    private Button deleteButton;
    @FXML
    private DatePicker pedido_data;
    @FXML
    private ListView<?> pedido_list_produto;

    
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
