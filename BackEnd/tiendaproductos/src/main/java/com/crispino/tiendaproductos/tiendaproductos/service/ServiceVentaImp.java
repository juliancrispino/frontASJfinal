package com.crispino.tiendaproductos.tiendaproductos.service;

import com.crispino.tiendaproductos.tiendaproductos.model.Venta;
import com.crispino.tiendaproductos.tiendaproductos.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceVentaImp implements ServiceVenta{

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }


}
