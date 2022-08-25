package com.crispino.tiendaproductos.tiendaproductos.repository;

import com.crispino.tiendaproductos.tiendaproductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto>findByCategoria(String categoria);
    List<Producto> findByPrecioAfter(Float precioDado);
    Optional<List<Producto>> findByPrecioBefore(Float precioDado);
}
