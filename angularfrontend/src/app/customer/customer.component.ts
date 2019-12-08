import { Component, OnInit } from '@angular/core';
import {Customer} from "../model/customer";
import {CustomerService} from "../service/customer.service";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customer = {} as Customer;
  constructor(private customerService: CustomerService,private router:Router) { }

  ngOnInit() {
  }

  signup(){
    console.log(this.customer);
    this.customerService.signup(this.customer);

    this.router.navigate(['/home']);
  }
}
