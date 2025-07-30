package com.concessionaria.lojacarros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendedor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    @JsonIgnore()
    private List<Venda> vendas = new ArrayList<>();

    public Vendedor() {

    }

    public Vendedor(Integer id, String nome, String cpf, List<Venda> vendas) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.vendas = vendas;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
