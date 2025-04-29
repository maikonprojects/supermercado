package com.mercado.mercado.repository;

import com.mercado.mercado.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
