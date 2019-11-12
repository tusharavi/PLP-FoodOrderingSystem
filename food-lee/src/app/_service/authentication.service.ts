import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

export class User {
  constructor(
    public status: string,
  ) { }

}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  user: any = {}
  role: string

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }
  //this function gets the username and passord from component and connects 
  //to the database for if credentials are valid then JWT token is retreived.
  authenticate(username, password) {
    return this.httpClient.post<any>('http://15.206.163.15:9750/login', { username, password }).subscribe
      (
        (data) => {
          sessionStorage.setItem('username', username);
          let tokenStr = 'Bearer ' + data.token;
          alert(tokenStr);
          sessionStorage.setItem('token', tokenStr);
          this.user = data;
          return data;
        }, (error) => {
          this.router.navigate(['login'])
        }
      )

  }
  getDbUser(username): any {
    // this.user = this.httpClient.get("http://15.206.163.15:9750/getUser?loginName=" + loginName).subscribe(
    this.user = this.httpClient.get("http://15.206.163.15:9750/user/"+username).subscribe(
      (data) => {
        if (data["roles"] === 'ROLE_ADMIN') {
          sessionStorage.setItem('roles', this.user.admin);
          this.router.navigate(['/admin-home'])
        }
        else {
          console.log(data);
          this.router.navigate(['/user-home'])
        }
      })
  }

  isUserLoggedIn():boolean {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('userId');
    sessionStorage.removeItem('userRole');
    sessionStorage.removeItem('userName');
  }
  getUserRole() {
    return this.role;
  }

}