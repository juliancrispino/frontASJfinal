import { Component, OnInit } from '@angular/core';
import {Venta} from "../../venta";
import {VentaService} from "../../venta.service";

@Component({
  selector: 'app-lista-ventas',
  templateUrl: './lista-ventas.component.html',
  styleUrls: ['./lista-ventas.component.css']
})
export class ListaVentasComponent implements OnInit {

  ventas:Venta[];   //Declaro un array de Venta llamado ventas

  constructor(private ventaService:VentaService) { }

  ngOnInit(): void {
    this.obtenerVentas();
  }

  private obtenerVentas(){
    this.ventaService.obtenerListaDeVentas().subscribe(dato => {
      this.ventas = dato;
    })
  }

}
