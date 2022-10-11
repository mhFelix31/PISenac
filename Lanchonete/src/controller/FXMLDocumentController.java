/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import model.ItemListPedido;
import model.ItemListPedido;
import model.ItemdeLista;
import model.ItemdeLista;
import model.ListaPrincipal;
import model.ListaPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author asdfq
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ListView<ItemdeLista> list;
    
    @FXML
    private ListView<ItemListPedido> listPedido;
    
    @FXML
    private FlowPane flow;
    
    @FXML
     private ScrollPane scrollListPrinc;
    
    ObservableList<ListaPrincipal> listMain = FXCollections.observableArrayList();

   // Image image = new Image(getClass().getResourceAsStream("lanchonete/img4.jpg"));

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
         list.setCellFactory( ly -> {
            return FXMLItemListController.newInstance();
        });
         
         listPedido.setCellFactory(ly -> {
             return FXMLItemListPedidoController.newInstance();
         });
         
        ObservableList<ItemListPedido> itemPedido = FXCollections.observableArrayList();
        itemPedido.add(new ItemListPedido().setImagePedido(new Image("lanchonete/img4.jpg")).setTextPedido("Hamburguer"));
        itemPedido.add(new ItemListPedido().setImagePedido(new Image("lanchonete/img4.jpg")).setTextPedido("Hamburguer"));
        itemPedido.add(new ItemListPedido().setImagePedido(new Image("lanchonete/img4.jpg")).setTextPedido("Hamburguer"));
        listPedido.setItems(itemPedido);
         
               
         
        ObservableList<ItemdeLista> item = FXCollections.observableArrayList();

        item.add(new ItemdeLista()
                .setCategoria("Felipe Souza")
        .setImage(new Image("lanchonete/img4.jpg")));
        item.add(new ItemdeLista().setCategoria("Souza")
        .setImage(new Image("lanchonete/img4.jpg")));
        item.add(new ItemdeLista().setCategoria("Felipe")
        .setImage(new Image("lanchonete/img4.jpg")));
        item.add(new ItemdeLista().setCategoria("mortadela")
        .setImage(new Image("lanchonete/img4.jpg")));
        item.add(new ItemdeLista().setCategoria("ultimo")
        .setImage(new Image("lanchonete/img4.jpg")));
        list.setItems(item);
        
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));
        listMain.add(new ListaPrincipal(new Image("lanchonete/img4.jpg")));

        scrollListPrinc.fitToWidthProperty().set(true);
        scrollListPrinc.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        
        
         flow.setVgap(20);
         flow.setHgap(50);
         flow.setPadding(new Insets(20, 20, 20, 20));
         flow.setAlignment(Pos.CENTER);
         flow.setPrefWrapLength(500); 
         flow.setPrefWidth(500);
         
         onSearch();
    }        
       @FXML
    public void onSearch() {
       for (int i = 0; i < listMain.size(); i++) {
             flow.getChildren().add(listMain.get(i));
         }
 }
}
