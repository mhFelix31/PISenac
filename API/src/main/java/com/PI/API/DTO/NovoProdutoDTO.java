package com.PI.API.DTO;

import com.PI.API.Model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NovoProdutoDTO(

        @NotBlank
        String nome,

        @NotNull
        float preco,


        String descricao,

        @NotNull
        boolean materiaPrima,

        int idCategoria,

        int idCobranca,

        String fullimage)
{
    public NovoProdutoDTO(Produto produto) {
        this(produto.getNome(),produto.getPreco(),produto.getDescricao(),produto.isMateriaPrima(),produto.getIdCategoria(),produto.getIdCobranca(),produto.getFullimage());
    }
}