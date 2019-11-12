import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantModel } from 'src/app/_model/restaurant.model';
import { RestaurantService } from 'src/app/_service/restaurant.service';
import { AuthenticationService } from 'src/app/_service/authentication.service';


@Component({
  selector: 'app-show-restaurant',
  templateUrl: './show-restaurant.component.html',
  styleUrls: ['./show-restaurant.component.css']
})



export class ShowRestaurantComponent implements OnInit, AfterViewInit {
  restaurants:RestaurantModel[] = [];

  ngAfterViewInit(): void {
   
  }
  

  constructor(private router:Router,
    private restaurantService:RestaurantService,
    private authenticationService:AuthenticationService
    
    ) { }

  ngOnInit() {
    this.restaurantService.getAllRestaurants().subscribe((restaurants: RestaurantModel[]) => {
    this.restaurants = restaurants});
    console.log(this.restaurants);
  }

  onSelect(restaurant) {
    this.router.navigate(['/show-restaurant',restaurant.restaurantId]);
  }
  
  role:any;
  isAdmin():boolean {
    this.role = sessionStorage.getItem("roles");
    if(this.role == "ROLE_ADMIN") {
      return true;
    } else {
      return false;
    } 
  }

  isLoggedIn():boolean {
    return this.authenticationService.isUserLoggedIn();
  }


}
