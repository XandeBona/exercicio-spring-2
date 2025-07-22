package com.concessionaria.lojacarros.repositories;

import com.concessionaria.lojacarros.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
