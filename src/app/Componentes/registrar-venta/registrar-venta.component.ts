import { Component, OnInit } from '@angular/core';
import {VentaInfo} from "../../ventaInfo";
import {VentaInfoService} from "../../ventaInfo.service";

interface formNuevaVenta{
  vendedor_id: number;
  carrito: {
    producto_id: number;
    cantidad: number;
  };
}


@Component({
  selector: 'app-registrar-venta',
  templateUrl: './registrar-venta.component.html',
  styleUrls: ['./registrar-venta.component.css']
})
export class RegistrarVentaComponent implements OnInit {

  //Para relacionar con el ngModel
  nuevaVenta : VentaInfo = new VentaInfo()


  modelo = {                 //Modelo inicial. Gracias a la two way binding, aca puedo poner un dato x defecto.
    vendedor_id: "",
    carrito: {
      producto_id: "",
      cantidad: ""
    }
  }

  constructor(private ventaInfoServicio:VentaInfoService) { }


  ngOnInit(): void {
  }


  guardarVenta(){
    this.ventaInfoServicio.registrarVenta(this.modelo).subscribe(dato => {
      console.log(dato);
    }, error => console.log(error));
  }


  onSubmit(formNuevaVenta: any){
    console.log(this.modelo)
    this.guardarVenta();


  }

}
