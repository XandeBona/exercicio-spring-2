package com.concessionaria.lojacarros.entities;

public class Venda {
    private Integer id;
    private String vendedor;
    private String carro;

    public Venda(Integer id, String vendedor, String carro) {
        this.id = id;
        this.vendedor = vendedor;
        this.carro = carro;
    }

    public Integer getId() {
        return id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getCarro() {
        return carro;
    }
}
