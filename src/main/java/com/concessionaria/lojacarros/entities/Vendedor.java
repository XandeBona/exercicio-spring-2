package com.concessionaria.lojacarros.entities;

public class Vendedor {
    private Integer id;
    private String nome;
    private String cpf;

    public Vendedor(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}
