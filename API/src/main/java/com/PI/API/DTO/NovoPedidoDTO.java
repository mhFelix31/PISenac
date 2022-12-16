package com.PI.API.DTO;

import com.PI.API.Model.Produto;
import com.PI.API.Model.statusPedido;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public record NovoPedidoDTO(
    statusPedido status,
    @NotNull
    Date data,
    int idCliente,
    int idFuncionario,
    @NotNull
    float valor,
    Set<Produto> produtos
		) {
}
