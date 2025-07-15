package com.concessionaria.lojacarros.controllers;

import com.concessionaria.lojacarros.entities.Carro;
import com.concessionaria.lojacarros.entities.Venda;
import com.concessionaria.lojacarros.entities.Vendedor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vendas")
public class VendasController {
    private List<Venda> lista;

    public VendasController() {
        Carro carro1 = new Carro(1, 88000.00, 2020, "Chevrolet Onix");
        Carro carro2 = new Carro(2, 100000.00, 2020, "Ford Fusion");
        Carro carro3 = new Carro(3, 108000.00, 2020, "Chevrolet Creta");
        Vendedor vendedor1 = new Vendedor(1, "Roberval", "12345678901");
        Vendedor vendedor2 = new Vendedor(2, "Roberto", "32185653370");
        Venda venda1 = new Venda(1, carro1.getMarca(), vendedor1.getNome());
        Venda venda2 = new Venda(2, carro2.getMarca(), vendedor2.getNome());
        Venda venda3 = new Venda(3, carro3.getMarca(), vendedor1.getNome());

        ArrayList<Venda> lista = new ArrayList<>();
        lista.add(venda1);
        lista.add(venda2);
        lista.add(venda3);
        this.lista = lista;
    }

    @GetMapping
    public List<Venda> listar() {
        return lista;
    }

    @GetMapping("/{idVenda}")
    public Venda buscarVenda(@PathVariable Integer idVenda) {
        for (Venda venda : lista) {
            if (Objects.equals(venda.getId(), idVenda)) {
                return venda;
            }
        }
        return null;
    }

}
