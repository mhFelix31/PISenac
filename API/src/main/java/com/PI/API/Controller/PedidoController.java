package com.PI.API.Controller;


import com.PI.API.DTO.NovoPedidoDTO;
import com.PI.API.DTO.PedidoDTO;
import com.PI.API.Model.Pedido;
import com.PI.API.Repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired(required = false)
    private PedidoRepository repository;


    @PostMapping
    @Transactional
    public void CriarPedido(@RequestBody @Valid NovoPedidoDTO dto) {
        repository.save(new Pedido(dto));
    }

    @GetMapping
    public Page<PedidoDTO> ListarComLimite(@PageableDefault(size=3,sort= {"data"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(PedidoDTO::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void AtualizarPedido(@PathVariable int id, @RequestBody @Valid NovoPedidoDTO dto) {
        Pedido pedido = repository.getReferenceById(id);
        pedido.Atualizar(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void CancelarPedido(@PathVariable int id) {
        Pedido pedido = repository.getReferenceById(id);
        pedido.Cancelar();
    }


}
