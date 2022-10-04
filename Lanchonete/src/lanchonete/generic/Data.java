/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import static java.lang.Integer.parseInt;

/**
 *
 * @author mateus.felix
 */
public class Data {
    public int dia;
    public int mes;
    public int ano;
    
    public Data(int dia,int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    public Data(String date){
        //1996-05-31
        String diatext = ""+(date.charAt(8)+date.charAt(9));
        String mestext = ""+(date.charAt(5)+date.charAt(6));
        String anotext = ""+(date.charAt(0)+date.charAt(1)+date.charAt(2)+date.charAt(3));
        dia = parseInt(diatext);
        mes = parseInt(mestext);
        ano = parseInt(anotext);
    }
    //Terminar implementação para conversão
    public String sqlConvert(){
        return String.format("",dia,mes,ano);
    }
}
