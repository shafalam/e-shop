import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AppComponent} from "./app.component";
import {ProductComponent} from "./product/product.component";
import {CustomerComponent} from "./customer/customer.component";

const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'products', component:ProductComponent},
  {path:'adduser', component:CustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
