/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import lanchonete.SqlHandler;
import lanchonete.generic.genericObj;
/**
 * FXML Controller class
 *
 * @author mHF
 */
public class FXMLadminController implements Initializable {
        
    public ListView<String> produtoList;
    
    @FXML
    public ScrollPane produtoSP;
    
    public AnchorPane produtoAP; 
    
    public FlowPane produtoFlow; 
    
    private List<genericObj> produtos = new ArrayList<genericObj>();    
    @FXML
    private ListView<String> list0;
    @FXML
    private ListView<String> list1;
    @FXML
    private ListView<String> list2;
    @FXML
    private ListView<String> list3;
    @FXML
    private ListView<CheckBox> list4;
    @FXML
    private ListView<String> list5;
    @FXML
    private ListView<String> list6;
    @FXML
    private ListView<String> list7;
    
    private SqlHandler sql = new SqlHandler();
     
    private String login = "root";
    private String senha = "admin";
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       createLists();
       //CreateSomething();
       CreateSomethingFlow();
    }    
       
    
    void createLists(){
        try{
        createProductList();
        }catch(Exception e){
            System.out.println("Não foi");
            System.out.println(e);
        }
    }

    
    void createProductList() throws IOException{
        try{
            produtos.clear();
            produtos = GetInfoDB("Produto");
        }
        catch(Exception e){
            System.out.println("Foi no pegar da db");
            System.out.println(e);
        }
        try{
            for (int i = 0; i < produtos.size(); i++){
                
                list0.getItems().add(produtos.get(i).getColunaValue(0));
                list1.getItems().add(produtos.get(i).getColunaValue(1));
                list2.getItems().add(produtos.get(i).getColunaValue(2));
                list3.getItems().add(produtos.get(i).getColunaValue(3));
                CheckBox cB = new CheckBox();
                cB.setSelected((produtos.get(i).getColunaValue(4).equals("1")));
                cB.disableProperty().set(true);
                list4.getItems().add(cB);
                Connection conn = connect();
                Statement st = sql.state(conn);
                ResultSet rs = sql.ReadCommand(st, sql.SelectColuna("Categoria","nome", String.format("WHERE %s = %s","IdCategoria",produtos.get(i).getColunaValue(5))));
                
                list5.getItems().add(rs.next()?rs.getString(1):produtos.get(i).getColunaValue(5));
                
                rs = sql.ReadCommand(st,sql.SelectColuna("Tipodecobrança","nome", String.format("WHERE %s = %s", "IdCobrança",produtos.get(i).getColunaValue(6))));
                list6.getItems().add(rs.next()?rs.getString(1):produtos.get(i).getColunaValue(6));
                conn.close();
                list7.getItems().add(produtos.get(i).getColunaValue(7));
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("ETA");
        }
        catch(NullPointerException  e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("Foi no loop");
            System.out.println(e);
        }
        
        
    }
        @FXML
        private ListView<genericObj> list;
        @FXML
        private FlowPane flowPaneReceitas;
        
        private List<FXMLLinhaTabelaController> ltControllers = new ArrayList<>();
        
        void CreateSomething(){
            try{
            //list.setCellFactory( ly -> {return FXMLLinhaTabelaController.newInstance();});
            ObservableList<genericObj> itemPedido = FXCollections.observableArrayList();
            
            
            
            itemPedido.addAll(GetInfoDB("Produto"));
            list.setItems(itemPedido);
            }
            catch(Exception e){
                System.out.println(e);
                
                System.out.println("CreateSomething");
            }
        
    }
        void CreateSomethingFlow(){
            
            try{
                ObservableList<genericObj> itemPedido = FXCollections.observableArrayList();

                itemPedido.addAll(GetInfoDB("Produto"));
                FXMLLoader loader = new FXMLLoader();
                //loader.setLocation(FXMLLinhaTabelaController.class.getResource("/View/FXMLLinhaTabela.fxml"));
                AnchorPane ap = null;
                Connection conn = connect();
                Statement st = sql.state(conn);
                List<String> categoria = new ArrayList<>();
                List<String> tipoCobranca = new ArrayList<>();
                ResultSet rs = sql.ReadCommand(st, sql.SelectAll("Categoria"));
                while(rs.next()){
                    categoria.add(rs.getString(2));
                }
                rs = sql.ReadCommand(st, sql.SelectAll("TipoDeCobrança"));
                while(rs.next()){                
                    tipoCobranca.add(rs.getString(2));
                }          
            
                
                
                for(int i = 0; i< itemPedido.size(); i++){  
                    loader = new FXMLLoader();
                    loader.setLocation(FXMLLinhaTabelaController.class.getResource("/View/FXMLLinhaTabela.fxml"));
                    ap = loader.load();                    
                    flowPaneReceitas.getChildren().add(ap);
                    ltControllers.add(loader.getController());
                    ltControllers.get(i).setGO(itemPedido.get(i));
                    ltControllers.get(i).categorias = categoria;
                    ltControllers.get(i).tipoCobrancas = tipoCobranca;
                    ltControllers.get(i).MainScreen = this;
                }
            }
            catch(Exception e){
                System.out.println(e);
                
                System.out.println("CreateSomething");
            }
        
    }
        
        
    private List<genericObj> GetInfoDB(String DB){
        List<genericObj> gO = new ArrayList<genericObj>();
        Connection conn = connect();
        Statement st = sql.state(conn);
        ResultSet rs = sql.ReadCommand(st, sql.SelectAll(DB));
        try {
            while (rs.next()) {                  
                gO.add(new genericObj(rs));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        sql.close(conn);
        return gO;       
    }
    
    private Connection connect(){
        return sql.Connect("localhost","3306","lanchonete",login,senha);
    }
    
    
    
    
    public void UpdateInfo(genericObj gO,String condition){
        Connection conn = connect();
        Statement st = sql.state(conn);
        System.out.println(sql.Update(gO.getTabela(), gO.colunasSql(), gO.valores(), condition));
        sql.SendCommand(st, sql.Update(gO.getTabela(), gO.colunasSql(), gO.valores(), condition));
        
    }
    
    
}
