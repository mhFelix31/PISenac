/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import model.ItemListPedido;
import model.ItemListPedido;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asdfq
 */
public class FXMLItemListPedidoController extends ListCell<ItemListPedido> implements Initializable {

    @FXML
    private AnchorPane root;
    
    @FXML
    private ImageView imagePedido;
    
    @FXML
    private ImageView imageCancelar;
    
    @FXML
    private Label textPedido;
    private ItemListPedido model;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        getRoot().getChildrenUnmodifiable().forEach( c ->{
            c.focusedProperty().addListener((obj,prev,curr) -> {
                if(!curr){
                    commitEdit(model);
                }
            });            
        });   
        setGraphic(root);
        
    }    
    
    public AnchorPane getRoot(){
        return root;
     }
    
    private static final Logger LOG = Logger.getLogger(FXMLItemListPedidoController.class.getName());

    public static FXMLItemListPedidoController newInstance() {
        FXMLLoader loader = new FXMLLoader(FXMLItemListPedidoController.class.getResource("/View/FXMLItemListPedido.fxml"));
        try {
            loader.load();
            return loader.getController();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void commitEdit(ItemListPedido newValue) {
        // if newValue isn't defined, use this.model
        newValue = (newValue == null) ? this.model : newValue;
        super.commitEdit(newValue); // <-- important
        // update the model with values from the text fields
        newValue.setImagePedido(imagePedido.imageProperty().get());
        newValue.setTextPedido(textPedido.textProperty().get());
    }
     @Override
    protected void updateItem(ItemListPedido item, boolean empty) {
        super.updateItem(item, empty); // <-- Important
        // make empty cell items invisible
        getRoot().getChildrenUnmodifiable().forEach(c -> c.setVisible(!empty));
        // update valid cells with model data
        if (!empty && item != null && !item.equals(this.model)) {
//           
            //Image image = new Image(getClass().getResourceAsStream(item.getImageCategoria()));
            imagePedido.imageProperty().set(item.getImagePedido());
            textPedido.textProperty().set(item.getTextPedido());
            
        }
        // keep a reference to the model item in the ListCell
        this.model = item;
    }
    
    @Override
    public void updateSelected(boolean selected) {
        super.updateSelected(selected);
        // update UI hints based on selected state
        getRoot().getChildrenUnmodifiable().forEach(c -> {
            // setting mouse-transparent to false ensure that
            // the cell will get selected we click on a field in
            // a non-selected cell
            c.setMouseTransparent(!selected);
            // focus-traversable prevents users from "tabbing"
            // out of the currently selected cell
            c.setFocusTraversable(selected);
        });
        if (selected) {
            // start editing when the cell is selected
            startEdit();
        } else {
            if (model != null) {
                // commit edits if the cell becomes unselected
                // we're not keeping track of "dirty" state
                // so this will commit changes even to unmodified cells
                commitEdit(model);
            }
        }
    }
}
