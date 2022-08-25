package com.crispino.tiendaproductos.tiendaproductos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "producto")
@JsonIgnoreProperties({"venta"})
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Float precio;

    private String categoria;

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "producto"
    )
    @JsonIgnoreProperties({"producto", "vendedor", "venta"})         //Evito loop
    private List<Venta> venta;
}
