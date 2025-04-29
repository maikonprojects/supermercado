package com.mercado.mercado.service;

import com.mercado.mercado.dto.ProdutoDados;
import com.mercado.mercado.entidade.Produto;
import com.mercado.mercado.repository.ProdutoRepository;
import org.hibernate.sql.model.PreparableMutationOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repositorio;

    public List<ProdutoDados> getProdutos() {

        List<Produto> lista = repositorio.findAll();

        return lista.stream()
                .map(produto -> new ProdutoDados(
                        produto.getNomeProduto(),
                        produto.getValor(),
                        produto.getQuantidade(),
                        produto.getDataValidade(),
                        produto.getDescricao(),
                        produto.getPeso(),
                        produto.getCategoria()))
                .collect(Collectors.toList());
    }

    public Produto putProduto(int id, Produto produtoNovo) {

        Produto produtoAtualizado = null;
        if (repositorio.existsById(id)) {
            produtoNovo.setId(id);
            produtoAtualizado = repositorio.save(produtoNovo);
        }

        return produtoAtualizado;
    }

    public void criarProduto(Produto produto) {

        repositorio.save(produto);

    }

    public boolean deletarProduto(int id) {


        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;

    }
}
