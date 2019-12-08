import { Component, OnInit } from '@angular/core';
import {ProductService} from "../service/product.service";
import {Product} from "../model/product";
import {CustomerService} from "../service/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[];

  constructor(private productService:ProductService, private customerService:CustomerService,
              private route:Router) {

  }

  ngOnInit() {
    this.productService.findProducts().subscribe(data=> {this.products = data});
  }

  onBuy(id:number){
    this.customerService.onBuy(id);
    this.route.navigate(['/home']);

  }
}
