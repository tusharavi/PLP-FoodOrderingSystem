import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FoodModel } from 'src/app/_model/food.model';
import { FoodService } from 'src/app/_service/food.service';
import { AuthenticationService } from 'src/app/_service/authentication.service';


@Component({
  selector: 'app-show-restaurant-food',
  templateUrl: './show-restaurant-food.component.html',
  styleUrls: ['./show-restaurant-food.component.css']
})


export class ShowRestaurantFoodComponent implements OnInit {
  public restaurantId;
  public restaurants:any;
  public foods:FoodModel[]=[];
  
  constructor(private activatedRoute:ActivatedRoute,
    private foodService: FoodService,
    private authenticationService: AuthenticationService
    ) { }

  ngOnInit() {
    let id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.restaurantId = id;
    this.foodService.getAllFood().subscribe((foods: FoodModel[]) => {
      this.foods = foods});
    console.log(this.restaurants);
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
