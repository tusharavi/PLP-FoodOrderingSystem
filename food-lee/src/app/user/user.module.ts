import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { MaterialModule } from '../_material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LogOutComponent } from './log-out/log-out.component';



@NgModule({
  declarations: [
    SignInComponent, 
    SignUpComponent, PageNotFoundComponent, LogOutComponent
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
    PageNotFoundComponent
  ]
})
export class UserModule { }
