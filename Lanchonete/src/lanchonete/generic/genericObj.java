/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import lanchonete.SqlHandler;
import lanchonete.generic.coluna;

/**
 *
 * @author mateus.felix
 */
public class genericObj extends sqlBasic{
    
    private coluna[] vars = new coluna[1];
    private String tableName;
    
    public void setTabela(String tableName){
        this.tableName = tableName;
    }
    
    public String getTabela(){
        return tableName;
    }
    
    public String getColunaValue(int i){
        return vars[i].value;
    }
    
    public void setColunaValue(int i,String value){
        vars[i].value = value;
    }
    public String getColunaName(int i){
        return vars[i].nome;
    }
    
    public int ColunaSize(){
        return vars.length;
    }
    
    
    public String toString(){
        String a = ".";
        String loop = "";
        for (int i = 0; i > vars.length; i++){
            a = a + " " + " Coluna " + vars[i].nome+ " Tabela" +vars[i].value;
        }
        return a;
    }

    public genericObj(coluna[] variaveis){
        this.vars = variaveis;
    }  
    
    
    
    public genericObj(ResultSet rs){
        try {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            tableName = rsMetaData.getTableName(1);
            vars = new coluna[rsMetaData.getColumnCount()];
           for(int i = 0; i < vars.length; i ++){
                vars[i] = new coluna(rsMetaData.getColumnName(i+1),rs.getString(i+1),rsMetaData.getColumnTypeName(i+1));
            }
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("ERROU");
        }
    }
    
    
    @Override
    public String PullInfo(String condicional) {
        
        return String.format("SELECT * FROM %s WHERE ",tableName,condicional);
        
    }
    

    @Override
    public void SendInfo(){        
        SqlHandler sql = new SqlHandler();
        sql.Insert(tableName, colunasSql(), valores());
    }
    
    @Override
    public coluna[] colunas() {
        return vars;

    }
    
    @Override
    public String[] colunasSql(){
        String[] col = new String[colunas().length];
        for (int i = 0;i<colunas().length;i++){
            col[i] = colunas()[i].nome;
        }
        return col;
    }

    @Override
    public String[] valores() {
        String[] val = new String[colunas().length];
        for (int i = 0;i<colunas().length;i++){
            val[i] = colunas()[i].value;
        }
        return val;
    }
    
    
    
}
