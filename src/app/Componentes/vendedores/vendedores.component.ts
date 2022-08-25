import { Component, OnInit } from '@angular/core';
import {Vendedores} from "../../vendedores";
import {VendedoresService} from "../../vendedores.service";

@Component({
  selector: 'app-vendedores',
  templateUrl: './vendedores.component.html',
  styleUrls: ['./vendedores.component.css']
})
export class VendedoresComponent implements OnInit {

  vendedor:Vendedores = new Vendedores();
  vendedores:Vendedores[];

  constructor(private vendedoresServicio:VendedoresService) { }

  ngOnInit(): void {
    this.obtenerVendedores();
  }

  guardarVendedores(){
    this.vendedoresServicio.registrarVendedor(this.vendedor).subscribe(dato => {
      console.log(dato);
    }, error => console.log(error));
  }

  onSubmit(formNuevoVendedor: any){
    console.log(this.vendedores)
    this.guardarVendedores();
    formNuevoVendedor.reset();
    this.obtenerVendedores();
  }

  private obtenerVendedores(){
    this.vendedoresServicio.obtenerListaDeVendedores().subscribe(dato => {
      this.vendedores = dato;
    })
  }

}
