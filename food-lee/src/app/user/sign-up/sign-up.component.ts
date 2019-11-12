import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormControl, FormGroup, FormBuilder, Validators, } from '@angular/forms';
import { UserModel } from 'src/app/_model/user.model';
import { RegistrationService } from 'src/app/_service/registration.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  usernameFormGroup: FormGroup;
  passwordFormGroup: FormGroup;
  emailFormGroup: FormGroup;
  telephoneFormGroup: FormGroup;

  isLinear = true;
  isEditable = false;
  hide = true;
  user: UserModel[] = [];
  registrationStatus:string='';


  constructor(private _snackBar: MatSnackBar, 
    private _formBuilder: FormBuilder,
    private service:RegistrationService,
    private router:Router
    ) { }
  //We could have used new FormGroup() instead at each node.

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message + ' registered', action, {
      duration: 2000,
    });
  }

  ngOnInit() {
    this.usernameFormGroup = this._formBuilder.group({
      usernameFormControl: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]*')]]
    });
    this.passwordFormGroup = this._formBuilder.group({
      passwordFormControl: ['', [Validators.required]]
    });
    this.emailFormGroup = this._formBuilder.group({
      emailFormControl: ['', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')]]
    });
    this.telephoneFormGroup = this._formBuilder.group({
      telephoneFormControl: ['', [Validators.required, Validators.pattern('[0-9]{10}')]]
    });
  }
  registerUser(): any {
    console.log(this.user);
    this.service.registerUser(this.user).subscribe((body) => console.log("ssssss"),
      error => {
      this.registrationStatus = error.error
        alert(error.error);
        this.router.navigate(['/login']);

      });
  }

}
