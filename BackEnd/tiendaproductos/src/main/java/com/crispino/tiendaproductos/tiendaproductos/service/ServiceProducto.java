package com.crispino.tiendaproductos.tiendaproductos.service;

import com.crispino.tiendaproductos.tiendaproductos.exceptions.ProductoNulo;
import com.crispino.tiendaproductos.tiendaproductos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ServiceProducto {

    List<Producto> obtenerProductos();
    Producto obtenerProductoPorId(Long id);
    List<Producto> obtenerProductoPorCategoria(String categoria);


    List<Producto> obtenerProductoPorPrecioMinimo(Float precio);

    Optional<List<Producto>> obtenerProductoPorPrecioMaximo(Float precio);

    Producto guardarProducto(Producto producto) throws ProductoNulo;

}
