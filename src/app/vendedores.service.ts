import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vendedores} from "./vendedores";

@Injectable({
  providedIn: 'root'
})
export class VendedoresService {

  private baseUrl = "http://localhost:8080/vendedor"

  constructor(private httpClient: HttpClient) { }

  obtenerListaDeVendedores():Observable<Vendedores[]>{
    return this.httpClient.get<Vendedores[]>(`${this.baseUrl}`);
  }

  registrarVendedor(vendedor:Vendedores) : Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`, vendedor);
  }

}
