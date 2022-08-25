package com.crispino.tiendaproductos.tiendaproductos.controller;

import com.crispino.tiendaproductos.tiendaproductos.model.Vendedor;
import com.crispino.tiendaproductos.tiendaproductos.service.ServiceVendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private  ServiceVendedor serviceVendedor;


    @GetMapping
    public List<Vendedor> obtenerTodosLosVendedores(){
        return this.serviceVendedor.obtenerVendedores();
    }

    @PostMapping
    public Vendedor guardarVendedor(@RequestBody Vendedor vendedor){
        return this.serviceVendedor.guardarVendedor(vendedor);
    }


}
