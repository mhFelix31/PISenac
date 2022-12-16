package com.PI.API.DTO;

import com.PI.API.Model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
        int id,

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
    public ProdutoDTO(Produto produto) {
        this(produto.getId(),produto.getNome(),produto.getPreco(),produto.getDescricao(),produto.isMateriaPrima(),produto.getIdCategoria(),produto.getIdCobranca(),produto.getFullimage());
    }
}
