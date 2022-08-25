import { Component, OnInit } from '@angular/core';
import {ProductoService} from "../../producto.service";
import {Producto} from "../../producto";

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  producto: Producto = new Producto();
  productos:Producto[];

  constructor(private productoServicio:ProductoService) { }

  ngOnInit(): void {
    this.obtenerProductos();
  }

  guardarProducto(){
    this.productoServicio.registrarProducto(this.producto).subscribe(dato => {
      console.log(dato);
    }, error => console.log(error));
  }

  onSubmit(formNuevoProducto: any){
    console.log(this.producto)
    this.guardarProducto();
    formNuevoProducto.reset();
    this.obtenerProductos();

  }

  private obtenerProductos(){
    this.productoServicio.obtenerListaDeProductos().subscribe(dato => {
      this.productos = dato;
    })
  }

}
