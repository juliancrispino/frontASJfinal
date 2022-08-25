package com.crispino.tiendaproductos.tiendaproductos.service;

import com.crispino.tiendaproductos.tiendaproductos.model.Vendedor;

import java.util.List;

public interface ServiceVendedor {

    List<Vendedor> obtenerVendedores();
    Vendedor guardarVendedor(Vendedor vendedor);

    Vendedor obtenerVendedorPorId(Long id);
}
