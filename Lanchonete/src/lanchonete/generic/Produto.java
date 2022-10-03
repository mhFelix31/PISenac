/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import java.util.*;

/**
 *
 * @author mateus.felix
 */
public class Produto extends sqlBasic{
    private int id;
    private String nome;
    private float preco;
    private String descricao;
    private String categoria;
    private String tipoDeCobranca;
    private String materiaPrima;
    
    private Data validade;
    private Data fabricacao;
    
    private int Quantidade;
    private List<String> localizacao = new ArrayList<String>();

    @Override
    public void PullInfo() {
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
    
    
    
    
    
    
}
