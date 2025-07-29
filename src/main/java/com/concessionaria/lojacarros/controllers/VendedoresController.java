package com.concessionaria.lojacarros.controllers;

import com.concessionaria.lojacarros.entities.Vendedor;
import com.concessionaria.lojacarros.repositories.VendedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedoresController {

    private final VendedorRepository vendedorRepository;

    public VendedoresController(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @GetMapping
    public List<Vendedor> listar() {
        return this.vendedorRepository.findAll();
    }

    @GetMapping("/{idVendedor}")
    public Vendedor buscarVendedor(@PathVariable Integer idVendedor) {
        return this.vendedorRepository.findById(idVendedor).get();
    }

    @PostMapping
    public Vendedor adicionarVendedor(@RequestBody Vendedor vendedor) {
        this.vendedorRepository.save(vendedor);
        return vendedor;
    }

    @PutMapping("/{idVendedor}")
    public Vendedor alterarVendedor(@PathVariable Integer idVendedor, @RequestBody Vendedor vendedor) {
        Vendedor alterar = this.vendedorRepository.findById(idVendedor).get();

        alterar.setNome(vendedor.getNome());
        alterar.setCpf(vendedor.getCpf());

        this.vendedorRepository.save(alterar);

        return alterar;
    }

    @DeleteMapping("/{idVendedor}")
    public Vendedor deletarVendedor(@PathVariable Integer idVendedor) {
        Vendedor vendedor = this.vendedorRepository.findById(idVendedor).get();

        this.vendedorRepository.deleteById(idVendedor);

        return vendedor;
    }
}
