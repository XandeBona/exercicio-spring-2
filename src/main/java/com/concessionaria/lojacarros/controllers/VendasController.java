package com.concessionaria.lojacarros.controllers;

import com.concessionaria.lojacarros.entities.Carro;
import com.concessionaria.lojacarros.entities.Venda;
import com.concessionaria.lojacarros.repositories.CarroRepository;
import com.concessionaria.lojacarros.repositories.VendaRepository;
import com.concessionaria.lojacarros.repositories.VendedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
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
    public List<Venda> listarVendas(@PathVariable Integer idCarro) {
        List<Venda> vendas = this.vendaRepository.findByCarroId(idCarro);
        return vendas;
    }

    @PostMapping
    public Venda criarVenda (
            @RequestBody Venda venda,
            @PathVariable Integer idCarro
    ) {
        Carro carro = this.carroRepository.findById(idCarro).orElseThrow();

        venda.setCarro(carro);
        this.vendaRepository.save(venda);
        return venda;
    }

}
