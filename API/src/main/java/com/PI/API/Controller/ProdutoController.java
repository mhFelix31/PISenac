package com.PI.API.Controller;


import com.PI.API.DTO.NovoProdutoDTO;
import com.PI.API.DTO.ProdutoDTO;
import com.PI.API.Model.Produto;
import com.PI.API.Repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;


    @PostMapping
    @Transactional
    public void Cadastro(@RequestBody NovoProdutoDTO dto) {
        repository.save(new Produto(dto));
        System.out.println("Cadastro");
    }

    @GetMapping
    public Page<ProdutoDTO> ListarComLimite(@PageableDefault(size = 3) Pageable paginacao) {
        System.out.println("Todos produtos da paginação");
        return repository.findAll(paginacao).map(ProdutoDTO::new);

    }
    @GetMapping("/todos")
    public List<ProdutoDTO> ListarTodos() {
        return repository.findAll().stream().map(ProdutoDTO::new).toList();
    }

    @GetMapping("/materia")
    public List<ProdutoDTO> ListarComLimiteMateriaPrima() {
        System.out.println("Materias Primas");
        return repository.findAllByMateriaPrimaTrue().stream().map(ProdutoDTO::new).toList();
    }
    @GetMapping("/final")
    public List<ProdutoDTO> ListarComLimiteProdutoFinal() {
        System.out.println("Produtos Finais");
        return repository.findAllByMateriaPrimaFalse().stream().map(ProdutoDTO::new).toList();
    }

    @GetMapping("/{id}")
    public void ListarPorId(@PathVariable int id) {
        System.out.println("Id: "+ id);
    }


    @PutMapping
    @Transactional
    public void AtualizarPorCorpo(@RequestBody @Valid ProdutoDTO dto) {
        var produto = repository.getReferenceById(dto.id());
        produto.Atualizar(dto);
        System.out.println("Atualizar");
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void DeletarProduto(@PathVariable int id) {
        repository.deleteById(id);
        System.out.println("Deletar");
    }



}
