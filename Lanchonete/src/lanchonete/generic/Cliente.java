/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import lanchonete.SqlHandler;

/**
 *
 * @author mateus.felix
 */
public class Cliente extends sqlBasic{
    private int id;
    private String Nome;
    private String Sobrenome;
    private Data nascimento;
    private int id_Instituição;
    private String Cargo;
    private String thumbnail,fullimage;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getNome() {return Nome;}
    public void setNome(String Nome) {this.Nome = Nome;}

    public String getSobrenome() {return Sobrenome;}
    public void setSobrenome(String Sobrenome) {this.Sobrenome = Sobrenome;}

    public Data getNascimento() {return nascimento;}
    public void setNascimento(Data nascimento) {this.nascimento = nascimento;}

    public int getId_Instituição() {return id_Instituição;}
    public void setId_Instituição(int id_Instituição) {this.id_Instituição = id_Instituição;}

    public String getCargo() {return Cargo;}
    public void setCargo(String Cargo) {this.Cargo = Cargo;}

    public String getThumbnail() {return thumbnail;}
    public void setThumbnail(String thumbnail) {this.thumbnail = thumbnail;}

    public String getFullimage() {return fullimage;}
    public void setFullimage(String fullimage) {this.fullimage = fullimage;}

    public Cliente(String Nome, String Sobrenome, Data nascimento, int id_Instituição, String Cargo, String thumbnail, String fullimage) {
        this.Nome = Nome;
        this.Sobrenome = Sobrenome;
        this.nascimento = nascimento;
        this.id_Instituição = id_Instituição;
        this.Cargo = Cargo;
        this.thumbnail = thumbnail;
        this.fullimage = fullimage;
        
        
    }
    
    public Cliente(int id){
        this.id = id;
    }
    
    public Cliente(){
        
    }
    
    
    @Override
    public void PullInfo() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SendInfo(){        
        SqlHandler sql = new SqlHandler();
        sql.Insert("Cliente", colunas(), valores());
    }
    
    @Override
    public String[] colunas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] valores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
