import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Producto} from "./producto";

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private baseUrl = "http://localhost:8080/productos"

  constructor(private httpClient: HttpClient) { }

  obtenerListaDeProductos():Observable<Producto[]>{
    return this.httpClient.get<Producto[]>(`${this.baseUrl}`);
  }

  registrarProducto(producto:Producto) : Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`, producto);
  }

}
