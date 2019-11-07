import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}


@Component({
  selector: 'app-show-restaurant-food',
  templateUrl: './show-restaurant-food.component.html',
  styleUrls: ['./show-restaurant-food.component.css']
})


export class ShowRestaurantFoodComponent implements OnInit {
  public restaurantId;
  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];
  constructor(private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    let id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
    this.restaurantId = id;
  }

}
