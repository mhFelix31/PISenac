/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

/**
 *
 * @author mateus.felix
 */
public abstract class sqlBasic {
    
    
    
    //Puxa informação da tabela
    public abstract void PullInfo();
    
    //Manda informação para a tabela
    public abstract void SendInfo();
    
    //Colunas da tabela
    public abstract String[] colunas();
    //valores da tabela
    public abstract String[] valores();
    
}
