import { Component } from '@angular/core';
import {AuthService} from "./auth/auth.service";
import {User} from './auth/User';
import {Router} from "@angular/router";
import {StreamService} from "./streams/stream.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  isLogged: boolean = false;

  constructor(private router:Router, private streamService: StreamService) {
  }

  checkIfLoggedIn(): boolean{
    if (localStorage.getItem('userToken') != null) {
      return true;
    }
    return false;
  }

  loginPage() {
      this.router.navigate(['/login'] );
  }

  logout() {
    localStorage.removeItem('userToken');
    this.router.navigate(['/']);
  }
}
