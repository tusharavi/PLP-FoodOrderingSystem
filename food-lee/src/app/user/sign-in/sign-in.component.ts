import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/_service/authentication.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  usernameFormGroup: FormGroup;
  passwordFormGroup: FormGroup;

  username: any;
  password: any;
  isLinear: boolean = true;
  isEditable: boolean = true;
  invalidLogin: boolean = true;
  hide:boolean = true;
  user:any;
  role:any;

  constructor(private _formBuilder: FormBuilder, 
    private loginservice: AuthenticationService, 
    private router: Router,  
    private authService: AuthenticationService,
    private myhttp:HttpClient
    ) { console.log("NIn in constructor"); }

  ngOnInit() {
    this.usernameFormGroup = this._formBuilder.group({
      usernameFormControl: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]*')]]
    });
    this.passwordFormGroup = this._formBuilder.group({
      passwordFormControl: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]*')]]
    });
    console.log("inside login component ");
  }

  authenticate(): any {
    console.log(this.username);
    console.log(this.password);
    this.authService.authenticate(this.username, this.password);
    this.user = sessionStorage.getItem('token');
    this.authService.getDbUser(this.username);
    this.role = this.authService.getUserRole();
    console.log(this.role);


    this.invalidLogin = false
  }
  setInvalidLogin(status) {
    this.invalidLogin = status
  }
    //this function gets the params from component and then registers the user
   
}
