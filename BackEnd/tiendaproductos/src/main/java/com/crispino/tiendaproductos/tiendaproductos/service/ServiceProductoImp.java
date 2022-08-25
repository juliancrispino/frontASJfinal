package com.crispino.tiendaproductos.tiendaproductos.service;

import com.crispino.tiendaproductos.tiendaproductos.exceptions.ProductoNulo;
import com.crispino.tiendaproductos.tiendaproductos.model.Producto;
import com.crispino.tiendaproductos.tiendaproductos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProductoImp implements ServiceProducto{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> obtenerProductoPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Producto> obtenerProductoPorPrecioMinimo(Float precio) {
        return productoRepository.findByPrecioAfter(precio);
    }

    @Override
    public Optional<List<Producto>> obtenerProductoPorPrecioMaximo(Float precio) {
        return productoRepository.findByPrecioBefore(precio);
    }

    @Override
    public Producto guardarProducto(@RequestBody Producto producto) throws ProductoNulo {

        if (producto == null) {
           throw new ProductoNulo("No se puede guardar un producto nulo");
        }
        return productoRepository.save(producto);
    }
}
