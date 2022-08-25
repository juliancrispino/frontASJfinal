package com.crispino.tiendaproductos.tiendaproductos.service;

import com.crispino.tiendaproductos.tiendaproductos.model.Vendedor;
import com.crispino.tiendaproductos.tiendaproductos.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVendedorImp implements ServiceVendedor{

    @Autowired
    private VendedorRepository vendedorRepository;


    @Override
    public List<Vendedor> obtenerVendedores() {
        return vendedorRepository.findAll();
    }

    @Override
    public Vendedor guardarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor obtenerVendedorPorId(Long id) {
        return vendedorRepository.findById(id).get();
    }


}
