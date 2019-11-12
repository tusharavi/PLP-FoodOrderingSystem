import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignInComponent } from './user/sign-in/sign-in.component';
import { SignUpComponent } from './user/sign-up/sign-up.component';
import { PageNotFoundComponent } from './user/page-not-found/page-not-found.component';
import { ShowRestaurantComponent } from './restaurant/show-restaurant/show-restaurant.component';
import { ShowRestaurantFoodComponent } from './food/show-restaurant-food/show-restaurant-food.component';
import { AdminHomeComponent } from './user/admin-home/admin-home.component';
import { UserHomeComponent } from './user/user-home/user-home.component';


const routes: Routes = [
  //The order should be from the most Specific to the least Specific TOP-DOWN Approach
  { path: '', redirectTo:'/show-restaurant', pathMatch:'full'}, //pathMatch can't have prefix as url
  { path: 'signin', component: SignInComponent},
  { path: 'signup', component: SignUpComponent},
  { path: 'admin-home', component: AdminHomeComponent },
  { path: 'user-home', component: UserHomeComponent },
  { path: 'show-restaurant', component: ShowRestaurantComponent},
  { path: 'show-food', component: ShowRestaurantFoodComponent},
  { path: 'logout', redirectTo:'/show-restaurant', pathMatch:'full'},
  { path: '**', component: PageNotFoundComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
