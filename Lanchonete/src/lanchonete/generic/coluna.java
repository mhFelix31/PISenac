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
public class coluna {
    public String nome;
    enum variavel{varchar,inteiro,flutuante,data}
    public variavel tipo;
    
    
    coluna (String nome, variavel tipo){
        this.nome = nome;
        this.tipo = tipo;
    }
}
