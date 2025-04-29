package com.mercado.mercado.dto;

import java.time.LocalDate;

public record ProdutoDados(String nomeProduto,
                           Double valor,
                           int quantidade,
                           LocalDate dtVencimento,
                           String descricao,
                           Double peso,
                           String categoria) {
}
