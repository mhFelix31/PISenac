package com.PI.API.Repository;

import com.PI.API.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    Collection<Produto> findAllByMateriaPrimaTrue();

    Collection<Produto> findAllByMateriaPrimaFalse();
}
