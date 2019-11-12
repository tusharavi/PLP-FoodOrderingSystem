import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  getAllFood() {
    return this.httpClient.get("http://13.233.160.132:9750/food-getall");
  }

  headers:any;
  constructor(private httpClient:HttpClient) { 
    this.headers = new HttpHeaders().set("Authorization",sessionStorage.getItem("token"));
  }

  deleteFood(foodId:any) {
    return this.httpClient.delete("http://13.233.160.132:9750/restaurant-delete/"+foodId);
  }

  updateFood(foodId:any, food:any) {
    return this.httpClient.put("http://13.233.160.132:9750/restaurant-delete/"+foodId, food);
  }
}
