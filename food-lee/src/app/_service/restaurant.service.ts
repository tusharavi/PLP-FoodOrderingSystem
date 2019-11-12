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
    return this.httpClient.get("http://15.206.163.15:9750/restaurant-getall", { headers: this.headers });
  }

}
