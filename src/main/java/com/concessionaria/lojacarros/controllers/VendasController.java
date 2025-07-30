package com.concessionaria.lojacarros.controllers;

import com.concessionaria.lojacarros.entities.Carro;
import com.concessionaria.lojacarros.entities.Venda;
import com.concessionaria.lojacarros.entities.Vendedor;
import com.concessionaria.lojacarros.repositories.CarroRepository;
import com.concessionaria.lojacarros.repositories.VendaRepository;
import com.concessionaria.lojacarros.repositories.VendedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores/{idVendedor}/vendas")
public class VendasController {
    private final CarroRepository carroRepository;
    private final VendedorRepository vendedorRepository;
    private final VendaRepository vendaRepository;

    public VendasController(CarroRepository carroRepository, VendedorRepository vendedorRepository, VendaRepository vendaRepository) {
        this.carroRepository = carroRepository;
        this.vendedorRepository = vendedorRepository;
        this.vendaRepository = vendaRepository;

    }

    @GetMapping
    public List<Venda> listarVendas(@PathVariable Integer idVendedor) {
        List<Venda> vendas = this.vendaRepository.findByVendedorId(idVendedor);
        return vendas;
    }

    @PostMapping
    public Venda criarVenda(@RequestBody Venda venda,
                            @PathVariable Integer idVendedor) {
        Integer idCarro = venda.getCarro().getId();

        Carro carro = carroRepository.findById(idCarro).orElseThrow();

        Vendedor vendedor = vendedorRepository.findById(idVendedor).orElseThrow();

        venda.setCarro(carro);
        venda.setVendedor(vendedor);

        this.vendaRepository.save(venda);
        return venda;
    }

}
