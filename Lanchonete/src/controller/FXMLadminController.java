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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
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

    private SqlHandler sql = new SqlHandler();

    private String login = "admin";
    private String senha = "admin";
    @FXML
    private FlowPane flowPaneReceitas;
    @FXML
    private FlowPane flowPaneCategoria;
    @FXML
    private FlowPane flowPanePedidos;
    @FXML
    private FlowPane flowPaneEstoque;
    @FXML
    private FlowPane flowPaneFuncionarios;
    @FXML
    private FlowPane flowPaneClientes;
    @FXML
    private FlowPane flowPaneParceiros;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createLists();
    }
    //`categoria`, `cliente`, `estoque`, `funcionarios`, `horario`, `instituição`, `pedido`, `produto`, `produtosnasreceitas`, `produtosnospedidos`, `receitas`, `tipodecobrança`
    void createLists() {
        try {
            createProductList();
            createList(flowPaneReceitas,"FXMLTabelaReceita","Receitas");
            createList(flowPaneCategoria,"FXMLTabelaCategoria","categoria");
            createList(flowPanePedidos,"FXMLTabelaPedido","pedido");
            createList(flowPaneEstoque,"FXMLTabelaEstoque","estoque");
            createList(flowPaneFuncionarios,"FXMLTabelaFuncionarios","funcionarios");
            createList(flowPaneClientes,"FXMLTabelaCliente","cliente");
            createList(flowPaneParceiros,"FXMLTabelaParceiros","instituição");
        } catch (Exception e) {
            System.out.println("Não foi");
            System.out.println(e);
        }
    }

    private ListView<genericObj> list;
    @FXML
    private FlowPane flowPaneProdutos;

    private List<FXMLTabelaProdutoController> ltControllers = new ArrayList<>();

    
    void createProductList() {

        try {
            flowPaneProdutos.getChildren().clear();
            ltControllers.clear();
            ObservableList<genericObj> itemPedido = FXCollections.observableArrayList();
            itemPedido.addAll(GetInfoDB("Produto"));
            FXMLLoader loader = new FXMLLoader();
            AnchorPane ap = null;
            Connection conn = connect();
            Statement st = sql.state(conn);
            List<String> categoria = new ArrayList<>();
            List<String> tipoCobranca = new ArrayList<>();
            ResultSet rs = sql.ReadCommand(st, sql.SelectAll("Categoria"));
            while (rs.next()) {
                categoria.add(rs.getString(2));
            }
            rs = sql.ReadCommand(st, sql.SelectAll("TipoDeCobrança"));
            while (rs.next()) {
                tipoCobranca.add(rs.getString(2));
            }

            for (int i = 0; i < itemPedido.size(); i++) {
                loader = new FXMLLoader();
                loader.setLocation(FXMLTabelaProdutoController.class.getResource("/View/FXMLTabelaProduto.fxml"));
                ap = loader.load();
                flowPaneProdutos.getChildren().add(ap);
                ltControllers.add(loader.getController());
                ltControllers.get(i).categorias = categoria;
                ltControllers.get(i).tipoCobrancas = tipoCobranca;
                ltControllers.get(i).MainScreen = this;
                ltControllers.get(i).index = i;
                ltControllers.get(i).listIndex = 0;
                ltControllers.get(i).setGO(itemPedido.get(i));

            }
            sql.close(conn);
        } catch (Exception e) {
            System.out.println(e);

            System.out.println("CreateProdutos");
        }

    }

    private List<genericObj> GetInfoDB(String DB) {
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

    private Connection connect() {
        return sql.Connect("localhost", "3306", "lanchonete", login, senha);
    }

    @FXML
    private void produtos_button_add(ActionEvent event) throws IOException {
        try {
            Connection conn = connect();
            System.out.println(conn == null?"Conn error":"Conection Ok");
            Statement st = sql.state(conn);
            System.out.println(st == null?"ST error":"ConectionST Ok");
            List<String> categoria = new ArrayList<>();
            List<String> tipoCobranca = new ArrayList<>();
            ResultSet rs = sql.ReadCommand(st, sql.SelectAll("Categoria"));
            while (rs.next()) {
                categoria.add(rs.getString(2));
            }
            rs = sql.ReadCommand(st, sql.SelectAll("TipoDeCobrança"));
            while (rs.next()) {
                tipoCobranca.add(rs.getString(2));
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FXMLAddProdutoController.class.getResource("/View/FXMLAddProduto.fxml"));
            Parent root = loader.load();
            FXMLAddProdutoController pC = loader.getController();
            pC.categorias = categoria;
            pC.tipoCobrancas = tipoCobranca;
            pC.MenuScreen = this;
            pC.Inicial();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void UpdateInfo(genericObj gO, String condition) {
        Connection conn = connect();
        Statement st = sql.state(conn);
        System.out.println(sql.Update(gO.getTabela(), gO.colunasSql(), gO.valores(), condition));
        sql.SendCommand(st, sql.Update(gO.getTabela(), gO.colunasSql(), gO.valores(), condition));
        sql.close(conn);
    }

    public void DeleteRequest(genericObj gO, String condition) {
        DeleteInfo(gO, condition);
    }

    void DeleteInfo(genericObj gO, String condition) {
        Connection conn = connect();
        Statement st = sql.state(conn);
        System.out.println(sql.Delete(gO.getTabela(), "*", condition));
        sql.SendCommand(st, sql.Delete(gO.getTabela(), "*", condition));
        createProductList();
        sql.close(conn);
    }

    public void AddInfo(genericObj gO, String condition) {
        Connection conn = connect();
        Statement st = sql.state(conn);
        System.out.println(sql.Insert(gO.getTabela(), gO.colunasSql(),gO.valores()));
        //sql.SendCommand(st, sql.Update(gO.getTabela(), gO.colunasSql(), gO.valores(), condition));
        createProductList();
        sql.close(conn);
    }

    public void SearchInfo(genericObj gO, String condition) {
        Connection conn = connect();
        Statement st = sql.state(conn);
        //System.out.println(sql.Update(gO.getTabela(), gO.colunasSql(), gO.valores(), condition));
        //sql.SendCommand(st, sql.Update(gO.getTabela(), gO.colunasSql(), gO.valores(), condition));  
        sql.close(conn);
    }

    @FXML
    private void receitas_button_add(ActionEvent event) {
    }

    @FXML
    private void categorias_button_add(ActionEvent event) {
    }

    @FXML
    private void pedido_button_add(ActionEvent event) {
    }

    @FXML
    private void estoque_button_add(ActionEvent event) {
    }

    @FXML
    private void funcionario_button_add(ActionEvent event) {
    }

    @FXML
    private void cliente_button_add(ActionEvent event) {
    }

    @FXML
    private void Parceiro_button_add(ActionEvent event) {
    }

    

    private void createList(FlowPane flow,String fxml,String DB) {
         try {
            flow.getChildren().clear();
            ltControllers.clear();
            ObservableList<genericObj> itemPedido = FXCollections.observableArrayList();
            itemPedido.addAll(GetInfoDB(DB));
            FXMLLoader loader = new FXMLLoader();
            AnchorPane ap = null;
          

            for (int i = 0; i < itemPedido.size(); i++) {
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/View/"+fxml+".fxml"));
                ap = loader.load();
                flow.getChildren().add(ap);
                ltControllers.add(loader.getController());
                ltControllers.get(i).MainScreen = this;
                ltControllers.get(i).setGO(itemPedido.get(i));

            }
        } catch (Exception e) {
            System.out.println(e);

            System.out.println("CreateReceita");
        }
    }

    

}
