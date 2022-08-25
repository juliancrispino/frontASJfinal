import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Venta} from "./venta";

@Injectable({
  providedIn: 'root'
})
export class VentaService {

  //URL para getAll
  private baseUrl = "http://localhost:8080/ventas"

  constructor(private httpClient: HttpClient) { }

  //Metodo para obtener las ventas
  //Observable: Patron de diseño. Debo hacer un subscribe
  obtenerListaDeVentas():Observable<Venta[]>{
    return this.httpClient.get<Venta[]>(`${this.baseUrl}`);
  }


}
