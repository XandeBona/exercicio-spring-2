package com.concessionaria.lojacarros.entities;

public class Carro {
    private Integer id;
    private Double preco;
    private Integer ano;
    private String marca;

    public Carro(Integer id, Double preco, Integer ano, String marca) {
        this.id = id;
        this.preco = preco;
        this.ano = ano;
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }
}
