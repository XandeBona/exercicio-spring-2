package com.concessionaria.lojacarros.controllers;

import com.concessionaria.lojacarros.entities.Carro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    private List<Carro> lista;

    public CarrosController() {
        Carro carro1 = new Carro(1, 46000.00, 2015, "Ford - New Fiesta");
        Carro carro2 = new Carro(2, 34000.00, 2015, "Ford - Ka");
        Carro carro3 = new Carro(3, 68000.00, 2015, "Ford - Focus");

        ArrayList<Carro> lista = new ArrayList<>();
        lista.add(carro1);
        lista.add(carro2);
        lista.add(carro3);
        this.lista = lista;
    }

    @GetMapping
    public List<Carro> listar() {
        return lista;
    }

    @GetMapping("/{idCarro}")
    public Carro buscarCarro(@PathVariable Integer idCarro) {
        for (Carro carro : lista) {
            if (Objects.equals(carro.getId(), idCarro)) {
                return carro;
            }
        }
        return null;
    }

    @PostMapping
    public Carro adicionarCarro(@RequestBody Carro carro) {
        carro.setId(new Random().nextInt());
        lista.add(carro);
        return carro;
    }

    @PutMapping("/{idCarro}")
    public Carro alterarCarro(@PathVariable Integer idCarro, @RequestBody Carro carro) {
        for(Carro carroAlterar : lista) {
            if (carroAlterar.getId().equals(idCarro)) {
                carroAlterar.setPreco(carro.getPreco());
                carroAlterar.setAno(carro.getAno());
                carroAlterar.setMarca(carro.getMarca());
                return carroAlterar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idCarro}")
    public Carro deletarCarro(@PathVariable Integer idCarro) {
        for (Carro carroRemover : lista) {
            if (carroRemover.getId().equals(idCarro)) {
                lista.remove(carroRemover);
                return carroRemover;
            }
        }
        return null;
    }
}
