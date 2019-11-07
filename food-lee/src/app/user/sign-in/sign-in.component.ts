import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/_service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  usernameFormGroup:FormGroup;
  passwordFormGroup:FormGroup;

  username:any;
  password:any;
  isLinear:boolean = true;
  isEditable:boolean = true;
  invalidLogin:boolean = true;

  constructor(private _formBuilder: FormBuilder, private loginservice: AuthenticationService,private router: Router) { }

  ngOnInit() {
    this.usernameFormGroup = this._formBuilder.group({
      usernameFormControl: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]*')]]
    });
    this.passwordFormGroup = this._formBuilder.group({
      passwordFormControl: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]*')]]
    });
  }

  checkLogin() {
    if (this.loginservice.authenticate(this.username, this.password)
    ) {
      this.router.navigate([''])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }
}
