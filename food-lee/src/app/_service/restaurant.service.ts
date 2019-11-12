import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { RestaurantModel } from '../_model/restaurant.model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  headers: any;

  constructor(private httpClient: HttpClient,
    private router: Router) {
    this.headers = new HttpHeaders().set("Authorization", sessionStorage.getItem("token"));
  }
  
  getAllRestaurants() {
    return this.httpClient.get("http://13.233.160.132:9750/restaurant-getall");
  }

  deleteRestaurant(restaurantId:any) {
    return this.httpClient.delete("http://13.233.160.132:9750/restaurant-delete/"+restaurantId);
  }

  updateRestaurant(restaurantId:any, restaurant:any) {
    return this.httpClient.put("http://13.233.160.132:9750/restaurant-delete/"+restaurantId, restaurant);
  }

}
