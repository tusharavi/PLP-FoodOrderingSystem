import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  getAllFood() {
    return this.httpClient.get("http://15.206.163.15:9750/food-getall");
  }

  headers:any;
  constructor(private httpClient:HttpClient) { 
    this.headers = new HttpHeaders().set("Authorization",sessionStorage.getItem("token"));
  }

  deleteFood(foodId:any) {
    return this.httpClient.delete("http://15.206.163.15:9750/restaurant-delete/"+foodId);
  }

  updateFood(foodId:any, food:any) {
    return this.httpClient.put("http://15.206.163.15:9750/restaurant-delete/"+foodId, food);
  }
}
