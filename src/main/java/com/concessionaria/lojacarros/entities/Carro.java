package com.concessionaria.lojacarros.entities;

import jakarta.persistence.*;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double preco;
    private Integer ano;
    private String marca;

    public Carro() {

    }

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
