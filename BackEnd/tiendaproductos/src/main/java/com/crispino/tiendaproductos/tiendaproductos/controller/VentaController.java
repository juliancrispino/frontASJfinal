package com.crispino.tiendaproductos.tiendaproductos.controller;


import com.crispino.tiendaproductos.tiendaproductos.DTO.VentaInfo;
import com.crispino.tiendaproductos.tiendaproductos.model.Producto;
import com.crispino.tiendaproductos.tiendaproductos.model.Vendedor;
import com.crispino.tiendaproductos.tiendaproductos.model.Venta;
import com.crispino.tiendaproductos.tiendaproductos.service.ServiceProducto;
import com.crispino.tiendaproductos.tiendaproductos.service.ServiceVendedor;
import com.crispino.tiendaproductos.tiendaproductos.service.ServiceVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private ServiceVenta serviceVenta;
    @Autowired
    private ServiceProducto serviceProducto;
    @Autowired
    private ServiceVendedor serviceVendedor;



    @GetMapping
    public List<Venta> obtenerTodasLasVentas(){
        return serviceVenta.obtenerVentas();
    }

    @GetMapping("/{id}")
    public Optional<Venta> obtenerVentaPorId(@PathVariable("id") Long id){
        return serviceVenta.obtenerVentaPorId(id);
    }

    @PostMapping
    public ResponseEntity<Object> guardarVenta(@RequestBody VentaInfo ventaInfo){

        //Encuentro el vendedor en BD, encuentro los productos
        Vendedor vendedor = this.serviceVendedor.obtenerVendedorPorId(ventaInfo.getVendedor_id());
        List<Producto> listaProductos = new ArrayList<>();      //tiene el metodo add
        double precioTotal = 0;
        int acumuladorProductos = 0;
        for (int i=0; i<ventaInfo.getCarrito().size(); i++) {
            Long producto_id = ventaInfo.getCarrito().get(i).getProducto_id();
            Long cantidad = ventaInfo.getCarrito().get(i).getCantidad();
            acumuladorProductos += cantidad;
            Producto producto = this.serviceProducto.obtenerProductoPorId(producto_id);
            precioTotal += cantidad * producto.getPrecio();
            listaProductos.add(producto);
        }
        Venta venta = new Venta();
        venta.setProducto(listaProductos);
        venta.setVendedor(vendedor);
        venta.setPrecioTotal((float) precioTotal);
        venta.setCantidadProductos(acumuladorProductos);

        float comision = 0;
        if (acumuladorProductos <=2){
            comision = (float) (precioTotal*0.05);
        } else if (acumuladorProductos >=3){
            comision= (float) (precioTotal*0.1);
        }
        venta.setComisionVenta(comision);
        return ResponseEntity.ok(serviceVenta.guardarVenta(venta));

    }

}
