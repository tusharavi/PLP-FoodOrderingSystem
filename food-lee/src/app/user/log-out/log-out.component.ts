import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/_service/authentication.service';


@Component({
  selector: 'app-log-out',
  templateUrl: './log-out.component.html',
  styleUrls: ['./log-out.component.css']
})
export class LogOutComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}


export class LogoutComponent implements OnInit {

  constructor(
    private authentocationService: AuthenticationService,
    private router: Router) {

  }

  ngOnInit() {
    this.authentocationService.logOut();
    this.router.navigate(['login']);
  }

}