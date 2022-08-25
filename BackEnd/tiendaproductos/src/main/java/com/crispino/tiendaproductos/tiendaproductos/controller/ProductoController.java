package com.crispino.tiendaproductos.tiendaproductos.controller;

import com.crispino.tiendaproductos.tiendaproductos.exceptions.ProductoNulo;
import com.crispino.tiendaproductos.tiendaproductos.model.Producto;
import com.crispino.tiendaproductos.tiendaproductos.service.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/productos")
public class ProductoController {


    @Autowired
    private ServiceProducto serviceProducto;


    @GetMapping
    public List<Producto> obtenerTodosLosProductos(){
        return this.serviceProducto.obtenerProductos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable("id") Long id) {
        Producto producto = this.serviceProducto.obtenerProductoPorId(id);
        if (producto != null){
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarProducto(@RequestBody Producto producto){
        try{
            Producto prod = this.serviceProducto.guardarProducto(producto);
            return ResponseEntity.ok(prod);
        } catch (ProductoNulo e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("No se puede agregar un producto nulo");
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Error desconocido");
        }

    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> obtenerProductosPorCategoria(@PathVariable("categoria") String categoria){
        List<Producto> productoPorCategoria = this.serviceProducto.obtenerProductoPorCategoria(categoria);
        if (productoPorCategoria.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productoPorCategoria);
        }
//    public List<Producto> obtenerProductosPorCategoria(@PathVariable("categoria") String categoria){
//        return this.serviceProducto.obtenerProductoPorCategoria(categoria);
    }

    @GetMapping("/minimo/{precio}")
    public ResponseEntity<?> obtenerProductoPrecioMinimo(@PathVariable("precio") Float precio){
        List<Producto> productoPorMinimo = this.serviceProducto.obtenerProductoPorPrecioMinimo(precio);
        if (productoPorMinimo.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productoPorMinimo);
        }

        //        return this.serviceProducto.obtenerProductoPorPrecioMinimo(precio);
    }

    @GetMapping("/maximo/{precio}")
    public Optional<List<Producto>> obtenerProductoPrecioMaximo(@PathVariable("precio") Float precio){
        return this.serviceProducto.obtenerProductoPorPrecioMaximo(precio);
    }
}
