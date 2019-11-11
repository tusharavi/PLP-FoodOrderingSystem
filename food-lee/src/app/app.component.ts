import { Component, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';

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
}