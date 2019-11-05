import { Component, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  @ViewChild(MatSidenav, { static: true }) sidenav: MatSidenav;
  toggleSidenav() {
    this.sidenav.toggle();
    console.log(this.sidenav.toggle);
  }
  events: string[] = [];
  title = 'food-lee';
  opened = true;

  shouldRun = [/(^|\.)plnkr\.co$/, /(^|\.)stackblitz\.io$/].some(h => h.test(window.location.host));
}
