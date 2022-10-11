/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author asdfq
 */
public class ItemListPedido {
    
    private Image imagePeddo;
    private final StringProperty textPedido = new SimpleStringProperty();
    
    public ItemListPedido(){
        
    }

    public Image getImagePedido() {
        return imagePeddo;
    }

    public ItemListPedido setImagePedido(Image imagePeddo) {
        this.imagePeddo = imagePeddo;
        return this;
    }
    
   public StringProperty textPedidoProperty() {
        return textPedido;
    }
       
       public String getTextPedido() {
        return textPedidoProperty().get();
    }
       
       public ItemListPedido setTextPedido(String value) {
        textPedidoProperty().set(value);
        return this;
    }    
    
    
}
