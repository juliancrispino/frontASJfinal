package com.crispino.tiendaproductos.tiendaproductos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VentaHelper {
    private Long producto_id;
    private Long cantidad;

    //Creo el helper porque en ventaInfo recibo un array de producto_id y cantidad
}
