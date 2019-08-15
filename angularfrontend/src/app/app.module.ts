import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import {HttpClientModule} from "@angular/common/http";
import {ProductService} from "./service/product.service";
import {CustomerService} from "./service/customer.service";
import { CustomerComponent } from './customer/customer.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ProductService, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
