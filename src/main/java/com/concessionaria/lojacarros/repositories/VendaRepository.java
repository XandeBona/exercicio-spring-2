package com.concessionaria.lojacarros.repositories;

import com.concessionaria.lojacarros.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
    List<Venda> findByCarroId(Integer idCarro);
}
