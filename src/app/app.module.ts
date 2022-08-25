import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaVentasComponent } from './Componentes/lista-ventas/lista-ventas.component';
import {HttpClientModule} from "@angular/common/http";
import { RegistrarVentaComponent } from './Componentes/registrar-venta/registrar-venta.component';
import {FormsModule} from "@angular/forms";
import { ProductosComponent } from './Componentes/productos/productos.component';
import { VendedoresComponent } from './Componentes/vendedores/vendedores.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaVentasComponent,
    RegistrarVentaComponent,
    ProductosComponent,
    VendedoresComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
