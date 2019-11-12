import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private httpClient:HttpClient) { }

  registerUser(user:any){
    return this.httpClient.post("http://15.206.163.15:9750/signup",user);
  }
}
