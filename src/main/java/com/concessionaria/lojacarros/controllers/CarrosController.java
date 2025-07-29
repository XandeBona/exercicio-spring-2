package com.concessionaria.lojacarros.controllers;

import com.concessionaria.lojacarros.entities.Carro;
import com.concessionaria.lojacarros.repositories.CarroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    private final CarroRepository carroRepository;

    public CarrosController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @GetMapping
    public List<Carro> listar() {
        return this.carroRepository.findAll();
    }

    @GetMapping("/{idCarro}")
    public Carro buscarCarro(@PathVariable Integer idCarro) {
        return this.carroRepository.findById(idCarro).get();
    }

    @PostMapping
    public Carro adicionarCarro(@RequestBody Carro carro) {
        this.carroRepository.save(carro);
        return carro;
    }

    @PutMapping("/{idCarro}")
    public Carro alterarCarro(@PathVariable Integer idCarro, @RequestBody Carro carro) {
        Carro alterar = this.carroRepository.findById(idCarro).get();

        alterar.setPreco(carro.getPreco());
        alterar.setAno(carro.getAno());
        alterar.setMarca(carro.getMarca());

        this.carroRepository.save(alterar);

        return alterar;
    }

    @DeleteMapping("/{idCarro}")
    public Carro deletarCarro(@PathVariable Integer idCarro) {
        Carro carro = this.carroRepository.findById(idCarro).get();

        this.carroRepository.deleteById(idCarro);

        return carro;
    }
}
