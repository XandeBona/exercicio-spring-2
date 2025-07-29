package com.concessionaria.lojacarros.repositories;

import com.concessionaria.lojacarros.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}
