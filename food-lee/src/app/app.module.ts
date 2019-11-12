import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MaterialModule } from './_material/material.module';
import { FormsModule } from '@angular/forms';
import { UserModule } from './user/user.module';
import { FoodOrderModule } from './food-order/food-order.module';
import { AccountModule } from './account/account.module';
import { RestaurantModule } from './restaurant/restaurant.module';
import { FoodModule } from './food/food.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    
    UserModule,
    FoodOrderModule,
    AccountModule,
    RestaurantModule,
    FoodModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
