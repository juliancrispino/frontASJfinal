import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListaVentasComponent} from "./Componentes/lista-ventas/lista-ventas.component";
import {RegistrarVentaComponent} from "./Componentes/registrar-venta/registrar-venta.component";
import {ProductosComponent} from "./Componentes/productos/productos.component";
import {VendedoresComponent} from "./Componentes/vendedores/vendedores.component";

const routes: Routes = [
  {path : 'ventas', component:ListaVentasComponent},
  {path : '', redirectTo:'ventas', pathMatch:'full'},
  {path : 'registrar-venta', component:RegistrarVentaComponent},
  {path : 'productos', component:ProductosComponent},
  {path : 'vendedores', component:VendedoresComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
