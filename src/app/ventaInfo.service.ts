import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {VentaInfo} from "./ventaInfo";

@Injectable({
  providedIn: 'root'
})
export class VentaInfoService {

  //URL para getAll
  private baseUrl = "http://localhost:8080/ventas"

  constructor(private httpClient:HttpClient) { }

  //Observable: Patron de diseño. Debo hacer un subscribe
  registrarVenta(ventaInfo: { carrito: { producto_id: string; cantidad: string }; vendedor_id: string }):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`, ventaInfo)
  }

}
