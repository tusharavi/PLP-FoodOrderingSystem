import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowRestaurantComponent } from './show-restaurant/show-restaurant.component';
import { FoodModule } from '../food/food.module';
import { MaterialModule } from '../_material/material.module';
import { AppRoutingModule } from '../app-routing.module';



@NgModule({
  declarations: [ShowRestaurantComponent],
  imports: [
    CommonModule,
    FoodModule,
    MaterialModule,
    AppRoutingModule,
  ],
  exports: [
    ShowRestaurantComponent,
  ]
})
export class RestaurantModule {
  

 }
