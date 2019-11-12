import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { MaterialModule } from '../_material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { UserHomeComponent } from './user-home/user-home.component';



@NgModule({
  declarations: [
    SignInComponent, 
    SignUpComponent, 
    PageNotFoundComponent, 
     AdminHomeComponent, 
     UserHomeComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    SignInComponent, 
    SignUpComponent, 
    PageNotFoundComponent, 
     AdminHomeComponent, 
     UserHomeComponent
  ]
})
export class UserModule { }
