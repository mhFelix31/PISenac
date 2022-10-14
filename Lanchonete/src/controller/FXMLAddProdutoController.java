/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import lanchonete.generic.coluna;
import lanchonete.generic.genericObj;

/**
 * FXML Controller class
 *
 * @author mHF
 */
public class FXMLAddProdutoController implements Initializable {

    @FXML
    private TextField produto_field_nome;
    @FXML
    private TextField produto_field_preco;
    @FXML
    private TextField produto_field_descricao;
    @FXML
    private CheckBox produto_check_materiaprima;
    @FXML
    private MenuButton menu_produto_categoria;
    @FXML
    private MenuButton menu_produto_tipocobranca;
    @FXML
    private TextField produto_field_image;
    @FXML
    private Button produto_button_adicionar;
    @FXML
    private Button produto_button_limpar;

    
    public FXMLadminController MenuScreen;
    
    
    public List<String> categorias = new ArrayList<>();
    public List<String> tipoCobrancas = new ArrayList<>();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    //`idProduto`, `Nome`, `Preço`, `Descrição`, `MateriaPrima`, `Categoria_idCategoria`, `TipoDeCobrança_idCobrança`, `fullimage`
    @FXML
    private void addProduto(ActionEvent event) {
        coluna[] col = new coluna[7];
        col[0] = new coluna("Nome",produto_field_nome.getText(),"int");
        col[1] = new coluna("Preço",produto_field_preco.getText(),"int");
        col[2] = new coluna("Descrição",produto_field_descricao.getText(),"int");
        col[3] = new coluna("MateriaPrima",produto_check_materiaprima.isSelected()?"1":"0","int");
        col[4] = new coluna("Categoria_idCategoria",String.valueOf(categorias.indexOf(menu_produto_categoria.getText())+1),"int");
        col[5] = new coluna("TipoDeCobrança_idCobrança",String.valueOf(tipoCobrancas.indexOf(menu_produto_tipocobranca.getText())+1),"int");
        col[6] = new coluna("fullimage",produto_field_image.getText(),"int");
        
        genericObj gO = new genericObj(col);
        gO.setTabela("Produto");
        MenuScreen.AddInfo(gO, "");
        
        Clearing();
        
        
    }
    public void Inicial(){        
     Menus(menu_produto_categoria,categorias);
     Menus(menu_produto_tipocobranca,tipoCobrancas);
    }
    
    
    void Menus(MenuButton menu,List<String> list){
        menu.getItems().clear();
        MenuItem menuitem;
        for (int i = 0; i < list.size(); i++){
            menuitem = new MenuItem(list.get(i));
            if (menu == menu_produto_categoria)menuitem.setOnAction(eventMenuCChange);
            else if (menu == menu_produto_tipocobranca)menuitem.setOnAction(eventMenuPChange);
            menu.getItems().add(menuitem);
        }
    }
    
    EventHandler<ActionEvent> eventMenuPChange = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                menu_produto_tipocobranca.setText(((MenuItem)e.getSource()).getText());
            }
    };
    EventHandler<ActionEvent> eventMenuCChange = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                menu_produto_categoria.setText(((MenuItem)e.getSource()).getText());
            }
    };
        
    @FXML
    private void Clear(ActionEvent event) {
        Clearing();
    }
    
    private void Clearing(){        
    produto_field_nome.setText("");
    produto_field_preco.setText("");
    produto_field_descricao.setText("");
    produto_check_materiaprima.setSelected(false);
    produto_field_image.setText("");       
    }
    
}
