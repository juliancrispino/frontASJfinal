package com.crispino.tiendaproductos.tiendaproductos.repository;

import com.crispino.tiendaproductos.tiendaproductos.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
