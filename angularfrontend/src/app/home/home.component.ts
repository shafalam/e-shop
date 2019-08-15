import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../service/customer.service";
import {Customer} from "../model/customer";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  loggedIn = false;
  customer:Customer;
  constructor(private cutomerServicce: CustomerService) {
  }

  ngOnInit() {
      if(this.cutomerServicce.getCustomer() != null){
        this.customer = this.cutomerServicce.getCustomer();
        this.loggedIn = true;
      }
      console.log(this.loggedIn);
  }

  onLogin(email:string, password:string){
    this.customer = this.cutomerServicce.onSignin(email,password);
    if (this.customer != null){
      this.loggedIn = true;
    }
  }

  signout(){
    this.cutomerServicce.setCustomer(null);
    this.loggedIn = false;
  }
}
