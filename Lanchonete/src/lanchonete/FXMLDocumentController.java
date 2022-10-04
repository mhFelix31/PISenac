/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lanchonete.generic.Cliente;
import lanchonete.generic.Data;

/**
 *
 * @author mateus.felix
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label mentira;
    
    @FXML
    private void alfafa(ActionEvent event) {
        mentira.setText("OI");
        Inicialzação();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     private SqlHandler sql = new SqlHandler();
    
    
    //Base de exemplo
    public void Inicialzação(){
        Connection conn = sql.Connect("localhost","3306","lanchonete","root","admin");
        Statement st = sql.state(conn);
        List<Cliente> clientes = new ArrayList<Cliente>();
        ResultSet rs = sql.ReadCommand(st, sql.SelectAll("Cliente"));
        try {
            while (rs.next()) {
                
                // tabelas : idCliente, Nome, Sobrenome, nascimento, Instituição, Cargo
                clientes.add(new Cliente(rs.getInt("idCliente"),rs.getString("Nome"),rs.getString("Sobrenome"),new Data(String.valueOf(rs.getDate("nascimento"))), rs.getString("Instituição"), rs.getString("Cargo")));
            }
        } catch (Exception e) {

        }
        sql.close(conn);
        
        for(int i = 0; i < clientes.size(); i++){
            System.out.println("CLIENTE:"+clientes.get(i).getNome());
        }
    }
    //-----------------------------------
    
}
