package com.crispino.tiendaproductos.tiendaproductos;

import com.crispino.tiendaproductos.tiendaproductos.model.Venta;
import com.crispino.tiendaproductos.tiendaproductos.service.ServiceVenta;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class TiendaproductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaproductosApplication.class, args);
	}
	@Autowired
	private ServiceVenta serviceVenta;

}
