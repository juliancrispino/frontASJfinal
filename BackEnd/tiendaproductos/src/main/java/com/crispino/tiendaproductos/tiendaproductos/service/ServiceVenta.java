package com.crispino.tiendaproductos.tiendaproductos.service;

import com.crispino.tiendaproductos.tiendaproductos.model.Venta;

import java.util.List;
import java.util.Optional;

public interface ServiceVenta {

    List<Venta> obtenerVentas();
    Optional<Venta> obtenerVentaPorId(Long id);
    Venta guardarVenta(Venta venta);


}
