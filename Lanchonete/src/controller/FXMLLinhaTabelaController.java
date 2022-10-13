/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import lanchonete.generic.genericObj;

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
    
    private genericObj gO;
    private boolean Editable;
    
    public FXMLadminController MainScreen;
    
    public List<String> categorias = new ArrayList<>();
    public List<String> tipoCobrancas = new ArrayList<>();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public genericObj getObject(){
        return gO;
    }
    
    public void setGO(genericObj gO){
        this.gO = gO;
        UpdateInfos();        
    }
    
    
    void UpdateInfos(){
        
        produto_field_id.setText(gO.getColunaValue(0) != null?gO.getColunaValue(0):"");
        produto_field_nome.setText(gO.getColunaValue(1) != null?gO.getColunaValue(1):"");
        produto_field_preco.setText(gO.getColunaValue(2) != null?gO.getColunaValue(2):"");
        produto_field_descricao.setText(gO.getColunaValue(3) != null?gO.getColunaValue(3):"");
        produto_field_image.setText(gO.getColunaValue(7) != null?gO.getColunaValue(7):"");
        //menu_produto_categoria.setText(gO.getColunaValue(5) != null?categorias.get(Integer.parseInt(gO.getColunaValue(5))):"");
        //Menus(menu_produto_categoria,categorias);
        //menu_produto_tipocobranca.setText(gO.getColunaValue(5) != null?tipoCobrancas.get(Integer.parseInt(gO.getColunaValue(6))):"");
        //Menus(menu_produto_tipocobranca,tipoCobrancas);
        
    }
    
    
    void Menus(MenuButton menu,List<String> list){
        menu.getItems().clear();
        for (int i = 0; i > list.size(); i++){
            MenuItem menuitem = new MenuItem(list.get(i));
            menu.getItems().add(menuitem);
        }
    }
    void SendInfoToDB(){
        gO.setColunaValue(0, produto_field_id.getText());
        gO.setColunaValue(1, produto_field_nome.getText());
        gO.setColunaValue(2, produto_field_preco.getText());
        gO.setColunaValue(3, produto_field_descricao.getText());
        gO.setColunaValue(7, produto_field_image.getText());
        
        MainScreen.UpdateInfo(gO,String.format("WHERE %s = '%s'", gO.getColunaName(0),gO.getColunaValue(0)));
        
        
    }
    
    void ToggleEdit(){
        produto_field_id.setEditable(Editable);
        produto_field_nome.setEditable(Editable);
        produto_field_preco.setEditable(Editable);
        produto_field_descricao.setEditable(Editable);
        produto_field_image.setEditable(Editable);
        menu_produto_categoria.setDisable(!Editable);
        menu_produto_tipocobranca.setDisable(!Editable);
    }
    
    
    @FXML
    public void edit(){
        if (Editable == true){            
            produto_button_editar.setText("Editar");
            SendInfoToDB();
            Editable = false;
            ToggleEdit();
        }
        else{            
            produto_button_editar.setText("Enviar");
            Editable = true;
            ToggleEdit();
        }
    }
    
    
}
