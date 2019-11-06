import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

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
  
  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit() {
    this.usernameFormGroup = this._formBuilder.group({
      usernameFormControl: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]*')]]
    });
    this.passwordFormGroup = this._formBuilder.group({
      passwordFormControl: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]*')]]
    });
  }

}
