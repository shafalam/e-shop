import { Injectable } from '@angular/core';
import {Customer} from "../model/customer";
import {Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {HttpClientModule} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  loggedIn:boolean;
  private customer: Customer;
  private baseUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  onSignin(email: string, password:string){
    let customerObservable:Observable<Customer>;
    customerObservable = this.http.get<Customer>(this.baseUrl.concat('/signin'),
      {params:new HttpParams().set('email',email).set('password',password)});
    customerObservable.subscribe(customer=> this.customer = customer);
    if(this.customer != null){
      this.loggedIn=true;
    }
    return this.customer;
  }

  signup(customer:Customer):Customer{
    customer.id = null;
    customer.buyingHistory = [];
    let customerObservable:Observable<Customer>;
    /**customerObservable = this.http.post<Customer>(this.baseUrl.concat('/adduser'),customer);
    customerObservable.subscribe(customerThis => this.customer = customerThis);*/

    // experimental code
    this.http.post<Customer>(this.baseUrl.concat('/adduser'),customer).subscribe(customerThis => this.customer = customerThis);

    if(this.customer != null){
      this.loggedIn=true;
    }
    console.log(this.customer);
    return this.customer;
  }

  onBuy(id: number){
    /*const buyParams = new HttpParams().set('customer_id', this.customer.id.toString()).set('product_id',id.toString());
    let buyOptions = {
      params:buyParams
    };*/
    this.http.get<Customer>(this.baseUrl.concat('/buy'),
      {params: new HttpParams().set('customer_id',this.customer.id.toString())
          .set('product_id', id.toString())}).subscribe(data => this.customer = data);
  }

  getCustomer(){
    return this.customer;
  }
  setCustomer(customer:Customer){
    this.customer = customer;
  }
}
