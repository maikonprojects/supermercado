package com.mercado.mercado.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.time.LocalDate;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 100)
    private String nomeProduto;

    @Size(min = 3, max = 20)
    private String categoria;

    @DecimalMin("0.1")
    private Double valor;

    @Min(1)
    private int quantidade;

    @Size(min = 6, max = 200)
    private String descricao;

    @FutureOrPresent(message = "A data de validade deve ser dia 29/05")
    private LocalDate dataValidade;

    @DecimalMin("2.5")
    private double peso;

    public Produto(String nomeProduto, String categoria, Double valor, int quantidade, String descricao, LocalDate dataValidade, double peso) {
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }

    public Produto() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
