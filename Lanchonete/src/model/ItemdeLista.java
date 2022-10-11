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
 * @author Fsouza
 */
public class ItemdeLista {
    
     private Image image; 
     private final StringProperty categoria = new SimpleStringProperty();
    
    public ItemdeLista(){
        
    }

    public Image getImage() {
        return image;
    }
    
    public ItemdeLista setImage(Image image) {
       this.image = image;
       return this;
    }
    
       public StringProperty categoriaProperty() {
        return categoria;
    }
       
       public String getCategoria() {
        return categoriaProperty().get();
    }
       
       public ItemdeLista setCategoria(String value) {
        categoriaProperty().set(value);
        return this;
    }
       
}
