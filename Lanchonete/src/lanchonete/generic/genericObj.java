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
    
    private coluna[] vars;

    

    public genericObj(coluna[] variaveis){
        this.vars = variaveis;
    }  
    
    
    
    public genericObj(ResultSet rs){
        try {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            vars = new coluna[rsMetaData.getColumnCount()];
            
            if (rs.next()) {
                for(int i = 0; i < vars.length; i ++){
                    vars[i].nome = rsMetaData.getColumnName(i);
                    vars[i].tipoString = rsMetaData.getColumnTypeName(i);
                    vars[i].value = rs.getString(vars[i].nome);                            
                }
            }
        } catch (Exception e) {
            
        }
    }
    
    
    @Override
    public String PullInfo() {
        return "";
        
    }
    

    @Override
    public void SendInfo(){        
        SqlHandler sql = new SqlHandler();
        sql.Insert("Cliente", colunasSql(), valores());
    }
    
    @Override
    public coluna[] colunas() {
        //coluna[] col = {new coluna("idCliente",coluna.variavel.inteiro),new coluna("Nome",coluna.variavel.varchar),new coluna("Sobrenome",coluna.variavel.varchar),new coluna("nascimento",coluna.variavel.data),new coluna("Instituição",coluna.variavel.inteiro),new coluna("Cargo",coluna.variavel.varchar)};
        return null;

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
        String[] val = new String[5];
        /*val[0] = String.valueOf(id);
        val[1] = String.valueOf(Nome);
        val[2] = String.valueOf(Sobrenome);
        val[3] = nascimento.sqlConvert();
        val[4] = String.valueOf(idInstituicao);
        val[5] = String.valueOf(Cargo);
        */
        return val;
    }
    
    
    
}
