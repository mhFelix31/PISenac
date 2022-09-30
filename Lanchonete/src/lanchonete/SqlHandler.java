package lanchonete;

import java.sql.*;

public class SqlHandler {
    
    public void main(){
        
    }
    
    
    
    public String Insert(String tabela, String[] colunas, String[] valores) {
        return String.format("INSERT INTO %s %s VALUES %s;", tabela, ParentesesLoop(colunas, ""), ParentesesLoop(valores, "'"));
    }

    public String ParentesesLoop(String[] Inside, String incremento) {
        String text = "";
        if (Inside.length == 1) {
            return "(" + incremento + Inside[0] + incremento + ")";
        }
        for (int i = 0; i < Inside.length; i++) {
            if (i == 0) {
                text = "(" + incremento + Inside[i] + incremento;
            } else if (i == Inside.length) {
                text += "," + incremento + Inside[i] + incremento;
            } else {
                text += "," + incremento + Inside[i] + incremento;
            }
        }
        return text;
    }

    public String Update(String tabela, String[] colunas, String[] valores, String Condition) {
        if (Igualador(colunas, valores).equals("ERROR")) {
            return "ERROR";
        }
        return String.format("UPDATE %s SET %s WHERE %s", tabela, Igualador(colunas, valores), Condition);
    }

    public String Igualador(String[] valoresiniciais, String[] valoresfinais) {
        String text = "";
        if (valoresiniciais.length != valoresfinais.length) {
            return "ERROR";
        }
        if (valoresiniciais.length == 1) {

        } else {
            for (int i = 0; i < valoresiniciais.length; i++) {
                if (i == valoresiniciais.length) {
                    text += valoresiniciais[i] + "=" + valoresfinais[i];
                } else {
                    text += valoresiniciais[i] + " = " + valoresfinais[i] + ",";
                }
            }
        }
        return text;
    }


    
    
    
}
