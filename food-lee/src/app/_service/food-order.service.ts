import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodOrderService {
  headers:any;
  constructor(private httpClient:HttpClient) { 
    this.headers = new HttpHeaders().set("Authorization",sessionStorage.getItem("token"));
  }
  getFoodOrder() {
    return this.httpClient.get("http://13.233.160.132:9750/restaurant-delete/");
  }
}
