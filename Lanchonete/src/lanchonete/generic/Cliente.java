/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import java.sql.ResultSet;
import java.sql.Statement;
import lanchonete.SqlHandler;
import lanchonete.generic.coluna;

/**
 *
 * @author mateus.felix
 */
public class Cliente extends sqlBasic{
    private int id = 0;
    private String Nome;
    private String Sobrenome;
    private Data nascimento;
    private int idInstituicao;
    private String Cargo;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getNome() {return Nome;}
    public void setNome(String Nome) {this.Nome = Nome;}

    public String getSobrenome() {return Sobrenome;}
    public void setSobrenome(String Sobrenome) {this.Sobrenome = Sobrenome;}

    public Data getNascimento() {return nascimento;}
    public void setNascimento(Data nascimento) {this.nascimento = nascimento;}

    public int getId_Instituição() {return idInstituicao;}
    public void setId_Instituição(int Instituicao) {this.idInstituicao = Instituicao;}

    public String getCargo() {return Cargo;}
    public void setCargo(String Cargo) {this.Cargo = Cargo;}


      public Cliente(int id,String Nome, String Sobrenome, Data nascimento, int idInstituicao, String Cargo) {
        this.id = id;
        this.Nome = Nome;
        this.Sobrenome = Sobrenome;
        this.nascimento = nascimento;
        this.idInstituicao = idInstituicao;
        this.Cargo = Cargo;
        
        
    }
    
    public Cliente(String Nome, String Sobrenome, Data nascimento, int idInstituicao, String Cargo) {
        this.Nome = Nome;
        this.Sobrenome = Sobrenome;
        this.nascimento = nascimento;
        this.idInstituicao = idInstituicao;
        this.Cargo = Cargo;
        
        
    }
    
    public Cliente(int id){
        this.id = id;
    }
    
    
    public Cliente(ResultSet rs){
        try {
            if (rs.next()) {
                this.id = rs.getInt(colunas()[0].nome);
                this.Nome = rs.getString(colunas()[1].nome);
                this.Sobrenome = rs.getString(colunas()[2].nome);
                //this.nascimento = new Data(String.valueOf((rs.getDate(colunas()[3].nome)));
                this.idInstituicao = rs.getInt(colunas()[4].nome);
                this.Cargo = rs.getString(colunas()[5].nome);
            }
        } catch (Exception e) {

        }
    }
    
    
    @Override
    public String PullInfo() {
        if (this.id != 0){
            return String.format("SELECT * FROM CLIENTE WHERE idCliente = %d",id);
        }
        else return "Error";
        
    }
    

    @Override
    public void SendInfo(){        
        SqlHandler sql = new SqlHandler();
        sql.Insert("Cliente", colunasSql(), valores());
    }
    
    @Override
    public coluna[] colunas() {
        coluna[] col = {new coluna("idCliente",coluna.variavel.inteiro),new coluna("Nome",coluna.variavel.varchar),new coluna("Sobrenome",coluna.variavel.varchar),new coluna("nascimento",coluna.variavel.data),new coluna("Instituição",coluna.variavel.inteiro),new coluna("Cargo",coluna.variavel.varchar)};
        return col;

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
        val[0] = String.valueOf(id);
        val[1] = String.valueOf(Nome);
        val[2] = String.valueOf(Sobrenome);
        val[3] = nascimento.sqlConvert();
        val[4] = String.valueOf(idInstituicao);
        val[5] = String.valueOf(Cargo);
        
        return val;
    }
    
    
    
}
