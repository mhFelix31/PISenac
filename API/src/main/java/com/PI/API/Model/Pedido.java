package com.PI.API.Model;

import com.PI.API.DTO.NovoPedidoDTO;
import com.PI.API.DTO.NovoProdutoDTO;
import com.PI.API.DTO.ProdutoDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.Set;


//JPA
@Table(name = "pedidos")
@Entity(name = "Pedido")
//Lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private statusPedido status;
    private Date data;
    private int idCliente;
    private int idFuncionario;
    private float valor;

    @ManyToMany
    @JoinTable(
            name = "produtos_in_pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private Set<Produto> produtos;


    public Pedido(NovoPedidoDTO pedido) {
        status = pedido.status();
        data = pedido.data();
        idCliente = pedido.idCliente();
        idFuncionario = pedido.idFuncionario();
        valor = pedido.valor();

        produtos = pedido.produtos();
    }


    public void Atualizar(@Valid NovoPedidoDTO dto) {
        if (dto.status() != null) status = dto.status();
        if (dto.data() != null) data = dto.data();
        if (dto.idCliente() != 0) idCliente = dto.idCliente();
        if (dto.idFuncionario() != 0) idFuncionario = dto.idFuncionario();
        if (dto.valor() != 0) valor = dto.valor();

        if (dto.produtos() != null) produtos = dto.produtos();

    }


    public void Cancelar() {
        status = statusPedido.CANCELADO;
    }

}