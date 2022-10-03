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
public class Data {
    public int dia;
    public int mes;
    public int ano;
    
    Data(int dia,int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    //Terminar implementação para conversão
    public String sqlConvert(){
        return String.format("",dia,mes,ano);
    }
}
