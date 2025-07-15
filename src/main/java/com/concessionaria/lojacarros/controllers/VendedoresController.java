package com.concessionaria.lojacarros.controllers;

import com.concessionaria.lojacarros.entities.Vendedor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vendedores")
public class VendedoresController {
    private List<Vendedor> lista;

    public VendedoresController() {
        Vendedor vendedor1 = new Vendedor(1, "Alexandre", "09167238609");
        Vendedor vendedor2 = new Vendedor(2, "Gabriel", "12157234708");
        Vendedor vendedor3 = new Vendedor(3, "Juvencio", "29164538332");

        ArrayList<Vendedor> lista = new ArrayList<>();
        lista.add(vendedor1);
        lista.add(vendedor2);
        lista.add(vendedor3);
        this.lista = lista;
    }

    @GetMapping
    public List<Vendedor> listar() {
        return lista;
    }

    @GetMapping("/{idVendedor}")
    public Vendedor buscarVendedor(@PathVariable Integer idVendedor) {
        for (Vendedor vendedor : lista) {
            if (Objects.equals(vendedor.getId(), idVendedor)) {
                return vendedor;
            }
        }
        return null;
    }

}
