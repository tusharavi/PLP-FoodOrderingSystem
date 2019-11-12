import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodOrderService {
  headers:any;
  constructor() { 
    this.headers = new HttpHeaders().set("Authorization",sessionStorage.getItem("token"));
  }
}
