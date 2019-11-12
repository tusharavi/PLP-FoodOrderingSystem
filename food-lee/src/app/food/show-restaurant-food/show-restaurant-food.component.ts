import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FoodModel } from 'src/app/_model/food.model';
import { FoodService } from 'src/app/_service/food.service';


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
    private foodService: FoodService
    ) { }

  ngOnInit() {
    let id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.restaurantId = id;
    this.foodService.getAllFood(this.restaurantId).subscribe((foods: FoodModel[]) => {
    this.foods = foods});
    console.log(this.restaurants);
  }

}
