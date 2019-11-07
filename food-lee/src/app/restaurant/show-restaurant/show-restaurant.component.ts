import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantModel } from 'src/app/_model/restaurant.model';

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-show-restaurant',
  templateUrl: './show-restaurant.component.html',
  styleUrls: ['./show-restaurant.component.css']
})



export class ShowRestaurantComponent implements OnInit {
  restaurant:RestaurantModel;
  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  constructor(private router:Router) { }

  ngOnInit() {
  }

  onSelect(restaurant) {
    this.router.navigate(['/show-restaurant',restaurant.restaurantId]);
  }

}
