package com.PI.API.Model;

import com.PI.API.DTO.NovoProdutoDTO;
import com.PI.API.DTO.ProdutoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;


//JPA
    @Table(name = "produtos")
    @Entity(name = "Produto")
    //Lombok
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    public class Produto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String nome;
        private float preco;
        private String descricao;
        private boolean materiaPrima;
        private int idCategoria;
        private int idCobranca;
        private String fullimage;

        @ManyToMany
        private Set<Pedido> pedidos;

        public Produto(ProdutoDTO produto) {
            id = produto.id();
            nome = produto.nome();
            preco = produto.preco();
            descricao = produto.descricao();
            materiaPrima = produto.materiaPrima();
            idCategoria = produto.idCategoria();
            idCobranca = produto.idCobranca();
            fullimage = produto.fullimage();
        }

        public Produto(NovoProdutoDTO produto) {
            nome = produto.nome();
            preco = produto.preco();
            descricao = produto.descricao();
            materiaPrima = produto.materiaPrima();
            idCategoria = produto.idCategoria();
            idCobranca = produto.idCobranca();
            fullimage = produto.fullimage();
        }

        public void Atualizar(String nome, float preco, String descricao, boolean materiaPrima, int idCategoria, int idCobranca, String fullimage) {
            if (nome != null) this.nome = nome;
            if (preco != 0) this.preco = preco;
            if (descricao != null) this.descricao = descricao;
            this.materiaPrima = materiaPrima;
            if (idCategoria != 0) this.idCategoria = idCategoria;
            if (idCobranca != 0) this.idCobranca = idCobranca;
            if (fullimage != null) this.fullimage = fullimage;
        }

        public void Atualizar(ProdutoDTO produto) {
            if (produto.nome() != null) this.nome = produto.nome();
            if (produto.preco() != 0) this.preco = produto.preco();
            if (produto.descricao() != null) this.descricao = produto.descricao();
            this.materiaPrima = produto.materiaPrima();
            if (produto.idCategoria() != 0) this.idCategoria = produto.idCategoria();
            if (produto.idCobranca() != 0) this.idCobranca = produto.idCobranca();
            if (produto.fullimage() != null) this.fullimage = produto.fullimage();
        }

    }
