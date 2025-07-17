package com.concessionaria.lojacarros.controllers;

import com.concessionaria.lojacarros.entities.Vendedor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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

    @PostMapping
    public Vendedor adicionarVendedor(@RequestBody Vendedor vendedor) {
        vendedor.setId(new Random().nextInt());
        lista.add(vendedor);
        return vendedor;
    }

    @PutMapping("/{idVendedor}")
    public Vendedor alterarVendedor(@PathVariable Integer idVendedor, @RequestBody Vendedor vendedor) {
        for (Vendedor vendedorAlterar : lista) {
            if (vendedorAlterar.getId().equals(idVendedor)) {
                vendedorAlterar.setNome(vendedor.getNome());
                vendedorAlterar.setCpf(vendedor.getCpf());
                return vendedorAlterar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idVendedor}")
    public Vendedor deletarVendedor(@PathVariable Integer idVendedor) {
        for (Vendedor vendedorRemover : lista) {
            if (vendedorRemover.getId().equals(idVendedor)) {
                lista.remove(vendedorRemover);
                return vendedorRemover;
            }
        }
        return null;
    }

}
