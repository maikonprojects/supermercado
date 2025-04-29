package com.mercado.mercado.controller;

import com.mercado.mercado.dto.ProdutoDados;
import com.mercado.mercado.entidade.Produto;
import com.mercado.mercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDados>> get() {
        return ResponseEntity.status(200).body(service.getProdutos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> produtoNovo(@PathVariable int id, @RequestBody Produto produtoNovo) {
        Produto retornado = service.putProduto(id, produtoNovo);
        if (retornado != null) {
            return ResponseEntity.status(200).body(retornado);
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Void> criarNovoProduto(@RequestBody Produto produto){
        service.criarProduto(produto);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarProduto(@PathVariable int id){
        Boolean deletar = service.deletarProduto(id);

        if (deletar == false){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(204).build();
    }


}

