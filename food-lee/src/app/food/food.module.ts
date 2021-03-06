import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowRestaurantFoodComponent } from './show-restaurant-food/show-restaurant-food.component';
import { ShowRestaurantComponent } from '../restaurant/show-restaurant/show-restaurant.component';
import { MaterialModule } from '../_material/material.module';
import { AppRoutingModule } from '../app-routing.module';



@NgModule({
  declarations: [ShowRestaurantFoodComponent],
  imports: [
    CommonModule,
    MaterialModule,
    AppRoutingModule
  ],
  exports: [
    ShowRestaurantFoodComponent,
  ]
})
export class FoodModule { }
