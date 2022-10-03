package lanchonete;

import java.sql.*;

public class SqlHandler {
    
    public void main(){
        
    }
    
    //Metodos para administrar a conexão com sql
    //-----------------------------------------------------------------------
    
    public Connection Connect(String ip,String porta, String schema,String login, String senha){
        try{
            String url = "jdbc:mysql://"+ip+":"+porta+""+schema+"/escola";
            return DriverManager.getConnection(url,login,senha);
        }
        catch(Exception e){
            System.err.println("Exceção encontrada na conexão");
            System.err.println(e);
        }
        return null;
    }
    
    public Statement state(Connection con){
        Statement st = null;
        try{
            st = con.createStatement();
        }
        catch(Exception e){
            System.err.println("Exceção encontrada na criação de statement");
            System.err.println(e);
        }
        return st;
    }
    
    public void close(Connection con){
        try{
        con.close();
        }
        catch(Exception e){            
            System.err.println("Exceção encontrada no fechamento de conexão");
            System.err.println(e);
        }
    }
    //-----------------------------------------------------------------------------------
    
    
    //Metodos de conversão Para linguagem sql
    public String Insert(String tabela, String[] colunas, String[] valores) {
        return String.format("INSERT INTO %s %s VALUES %s;", tabela, ParentesesLoop(colunas, ""), ParentesesLoop(valores, "'"));
    }

    public String Update(String tabela, String[] colunas, String[] valores, String Condition) {
        if (Igualador(colunas, valores).equals("ERROR")) {
            return "ERROR";
        }
        return String.format("UPDATE %s SET %s WHERE %s", tabela, Igualador(colunas, valores), Condition);
    }
    
    public String Create(){
        return "";
    }
    
    public String Select(String tabela,String coluna,String Condition){
        return String.format("SELECT %s FROM %s WHERE %s", tabela, coluna, Condition);
    }
    
    public String Delete(String tabela,String coluna,String Condition){
        return String.format("DELETE %s FROM %s WHERE %s", tabela, coluna, Condition);
    }
    //-------------------------------------------------------------------------------
    
    
    //Metodos de organizar dados 
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
    //-----------------------------------------------------------------------------
}