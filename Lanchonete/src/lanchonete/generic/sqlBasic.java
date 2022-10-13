/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import java.sql.Statement;

/**
 *
 * @author mateus.felix
 */
public abstract class sqlBasic {
    
    
    
    //Puxa informação da tabela
    public abstract String PullInfo(String condicional);
    
    //Manda informação para a tabela
    public abstract void SendInfo();
    
    //Colunas da tabela
    public abstract coluna[] colunas();
    
    
    public abstract String[] colunasSql();
    //valores da tabela
    public abstract String[] valores();
    
}
