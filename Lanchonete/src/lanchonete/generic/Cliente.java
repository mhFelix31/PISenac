/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import java.sql.ResultSet;
import java.sql.Statement;
import lanchonete.SqlHandler;

/**
 *
 * @author mateus.felix
 */
public class Cliente extends sqlBasic{
    private int id = 0;
    private String Nome;
    private String Sobrenome;
    private Data nascimento;
    private String Instituicao;
    private String Cargo;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getNome() {return Nome;}
    public void setNome(String Nome) {this.Nome = Nome;}

    public String getSobrenome() {return Sobrenome;}
    public void setSobrenome(String Sobrenome) {this.Sobrenome = Sobrenome;}

    public Data getNascimento() {return nascimento;}
    public void setNascimento(Data nascimento) {this.nascimento = nascimento;}

    public String getId_Instituição() {return Instituicao;}
    public void setId_Instituição(String Instituicao) {this.Instituicao = Instituicao;}

    public String getCargo() {return Cargo;}
    public void setCargo(String Cargo) {this.Cargo = Cargo;}


      public Cliente(int id,String Nome, String Sobrenome, Data nascimento, String Instituicao, String Cargo) {
        this.id = id;
        this.Nome = Nome;
        this.Sobrenome = Sobrenome;
        this.nascimento = nascimento;
        this.Instituicao = Instituicao;
        this.Cargo = Cargo;
        
        
    }
    
    public Cliente(String Nome, String Sobrenome, Data nascimento, String Instituicao, String Cargo) {
        this.Nome = Nome;
        this.Sobrenome = Sobrenome;
        this.nascimento = nascimento;
        this.Instituicao = Instituicao;
        this.Cargo = Cargo;
        
        
    }
    
    public Cliente(int id){
        this.id = id;
    }
    
    
    public Cliente(){
        
    }
    
    
    @Override
    public String PullInfo() {
        if (this.id != 0){
            return null;
        }
        else return "Error";
        
    }

    @Override
    public void SendInfo(){        
        SqlHandler sql = new SqlHandler();
        sql.Insert("Cliente", colunas(), valores());
    }
    
    @Override
    public String[] colunas() {
        String[] col = {"idCliente","Nome","Sobrenome","nascimento","Instituição","Cargo"};
        return col;

    }

    @Override
    public String[] valores() {
        String[] val = new String[5];
        val[0] = String.valueOf(id);
        val[1] = String.valueOf(Nome);
        val[2] = String.valueOf(Sobrenome);
        val[3] = nascimento.sqlConvert();
        val[4] = String.valueOf(Instituicao);
        val[5] = String.valueOf(Cargo);
        
        return val;
    }
    
    
    
}
