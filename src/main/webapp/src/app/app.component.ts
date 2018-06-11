import { Component } from '@angular/core';
import {AuthService} from "./auth/auth.service";
import {User} from './auth/User';
import {Router} from "@angular/router";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


  constructor(private router:Router) {
  }

  loginPage() {
      this.router.navigate(['/login'], );
  }
}
