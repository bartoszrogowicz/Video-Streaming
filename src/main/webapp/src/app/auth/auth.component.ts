import { Component, OnInit } from '@angular/core';
import {User} from "./User";
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html'
})
export class AuthComponent implements OnInit {
  errorMessage: string;

  private username = "";
  private password = "";
  isLoginError: boolean = false;

  constructor(private authService:AuthService, private router: Router) { }

  ngOnInit() {
  }


  login() {
    console.log(this.username + " " + this.password)
    this.authService.logIn(this.username, this.password)
      .subscribe((data : any)=>{
          console.log(localStorage.setItem('userToken',data.id_token))
          localStorage.setItem('userToken',data.id_token);
          this.router.navigate(['/']);
        },(err: HttpErrorResponse)=>{
          console.log(err)
          console.log("cos poszlo nie tak");
          this.isLoginError = true;
          this.errorMessage="Invalid credentials. ";
        }
      )
  }

}
