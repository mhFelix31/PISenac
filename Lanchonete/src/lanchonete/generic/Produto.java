/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete.generic;

import java.util.*;

/**
 *
 * @author mateus.felix
 */
public class Produto extends sqlBasic{
    private int id;
    private String nome;
    private float preco;
    private String descricao;
    private int idCategoria;
    private String tipoDeCobranca;
    private String materiaPrima;
    private String thumbnail,fullimage;
    
    private boolean produtofinal;
    
    private Data validade;
    private Data fabricacao;
    
    private int Quantidade;
    private final List<String> localizacao = new ArrayList<>();
    
    
    
    public String getThumbnail() {return thumbnail;}
    public void setThumbnail(String thumbnail) {this.thumbnail = thumbnail;}

    public String getFullimage() {return fullimage;}
    public void setFullimage(String fullimage) {this.fullimage = fullimage;}

    @Override
    public String PullInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SendInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     @Override
    public coluna[] colunas() {
        coluna[] col = { new coluna("idProduto",coluna.variavel.inteiro),new coluna("Nome",coluna.variavel.varchar),new coluna( "Preço",coluna.variavel.flutuante),new coluna( "Descrição",coluna.variavel.varchar),new coluna("Categoria",coluna.variavel.varchar),new coluna("Tipo de Cobrança",coluna.variavel.varchar),new coluna("MateriaPrima",coluna.variavel.inteiro),new coluna( "Validade",coluna.variavel.data),new coluna( "Fabricação",coluna.variavel.data),new coluna("thumbnail",coluna.variavel.varchar),new coluna("fullimage",coluna.variavel.varchar)};
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
        String[] val = new String[10];
        val[0] = String.valueOf(id);
        val[1] = String.valueOf(nome);
        val[2] = String.valueOf(preco);
        val[3] = String.valueOf(descricao);
        val[4] = String.valueOf(idCategoria);
        val[5] = String.valueOf(tipoDeCobranca);
        val[6] = String.valueOf(materiaPrima);
        val[7] = validade.sqlConvert();
        val[8] = fabricacao.sqlConvert();
        val[9] = String.valueOf(thumbnail);
        val[10] = String.valueOf(fullimage);

        return val;
    }
    
    
    
    
}
