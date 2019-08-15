import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl:string;
  constructor(private http:HttpClient) {
    this.baseUrl='http://localhost:8080/products';
  }

  public findProducts():Observable<Product[]>{
    console.log('http request is sending');
    return this.http.get<Product[]>(this.baseUrl);
  }
}
