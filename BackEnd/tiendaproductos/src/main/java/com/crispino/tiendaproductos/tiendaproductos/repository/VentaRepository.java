package com.crispino.tiendaproductos.tiendaproductos.repository;

import com.crispino.tiendaproductos.tiendaproductos.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
