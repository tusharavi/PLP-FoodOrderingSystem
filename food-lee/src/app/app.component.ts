import { Component, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { AuthenticationService } from './_service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild(MatSidenav, { static: true }) sidenav: MatSidenav;
  events: string[] = [];
  title = 'food-lee';
  opened = true;
  themeColor ='accent';
  username:any;
  roles:any;

  constructor(private authenticationService:AuthenticationService) {
    
  }

  logout() {
    this.authenticationService.logOut();
  }
  isUserLoggedIn():boolean{
    this.username = sessionStorage.getItem("username");
    return this.authenticationService.isUserLoggedIn();
  }
  isUserAdmin():boolean {
    this.roles = sessionStorage.getItem("roles");
    if(this.roles == "ROLE_ADMIN") {
      return true;
    } else {
      return false;
    }
  }
}