import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowRestaurantComponent } from './show-restaurant/show-restaurant.component';
import { FoodModule } from '../food/food.module';
import { MaterialModule } from '../_material/material.module';



@NgModule({
  declarations: [ShowRestaurantComponent],
  imports: [
    CommonModule,
    FoodModule,
    MaterialModule
  ],
  exports: [
    ShowRestaurantComponent,
  ]
})
export class RestaurantModule { }
