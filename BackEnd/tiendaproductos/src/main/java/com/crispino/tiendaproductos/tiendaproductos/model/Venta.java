package com.crispino.tiendaproductos.tiendaproductos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id;

    @Column(name = "cantidad_productos")
    private Integer cantidadProductos;

    @Column(name = "precio_total")
    private Float precioTotal;

    @Column(name = "comision_venta")
    private Float comisionVenta;


    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_vendedor")
    @JsonIgnoreProperties("sueldo")
    private Vendedor vendedor;

    @ManyToMany(
            fetch = FetchType.LAZY,             //Que tarde en traer los datos
            cascade = CascadeType.ALL           //Que modifique en todas las tablas cuando modifico aca
    )
    @JsonIgnore
    @JoinTable(                                 //Creo tabla intermedia
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    @JsonIgnoreProperties({"venta"})         //Evito loop
    private List<Producto> producto;            //mi campo de vendedor se asocia a uno de producto

}
