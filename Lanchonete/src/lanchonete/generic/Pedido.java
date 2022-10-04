/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import lanchonete.generic.Produto;
import java.util.*;
/**
 *
 * @author mateus.felix
 */
public class Pedido extends sqlBasic{

    @Override
    public String PullInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SendInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] colunas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] valores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private enum status{
        realizado,andamento,concluido
    }
    
    
    private int id;
    private Produto produto;
    private String observacoes;
    private float quantidade;
    private status statusPedido;
    private int idCliente;
    private int idFuncionario;
    private float valorTotal;
    
    private List<Produto> produtos = new ArrayList<Produto>();
    
    
    
}
