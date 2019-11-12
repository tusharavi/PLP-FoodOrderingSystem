import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantModel } from 'src/app/_model/restaurant.model';
import { RestaurantService } from 'src/app/_service/restaurant.service';


@Component({
  selector: 'app-show-restaurant',
  templateUrl: './show-restaurant.component.html',
  styleUrls: ['./show-restaurant.component.css']
})



export class ShowRestaurantComponent implements OnInit, AfterViewInit {
  restaurants:any = {};

  ngAfterViewInit(): void {
   
  }
  

  constructor(private router:Router,
    private restaurantService:RestaurantService ) { }

  ngOnInit() {
    this.restaurantService.getAllRestaurants().subscribe((response: any) => {
      this.restaurants = response});
    console.log(this.restaurants);
  }

  onSelect(restaurant) {
    this.router.navigate(['/show-restaurant',restaurant.restaurantId]);
  }
  

}
