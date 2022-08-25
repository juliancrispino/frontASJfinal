package com.crispino.tiendaproductos.tiendaproductos.DTO;

import lombok.Data;

import java.util.List;

@Data
public class VentaInfo {
    private Long vendedor_id;
    private List<VentaHelper> carrito;

}