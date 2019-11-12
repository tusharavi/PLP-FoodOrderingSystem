import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserModel } from '../_model/user.model';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  headers:any;

  constructor(private httpClient:HttpClient) { 
    this.headers = new HttpHeaders().set("Authorization",sessionStorage.getItem("token"));
  }

  registerUser(user:any){
    console.log(user+"here in service")
    let myForm = new FormData();
    myForm.append("username",user.username);
    myForm.append("password",user.password);
    myForm.append("telephone",user.telephone);
    myForm.append("email",user.telephone);

    return this.httpClient.post("http://15.206.163.15:9750/signup",{myForm:myForm});
  }
}
