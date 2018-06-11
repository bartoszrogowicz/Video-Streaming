import { Component, OnInit } from '@angular/core';
import {User} from "./User";
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  private username = "";
  private password = "";
  errorMessage: String;

  constructor(private authService:AuthService, private router: Router) { }

  ngOnInit() {
  }


  login() {
    console.log(this.username + " " + this.password)
    this.authService.logIn(this.username, this.password)
      .subscribe(data=>{
          this.router.navigate(['/']);
        },err=>{
          console.log("cos tam cos tam");
          this.errorMessage="error :  Username or password is incorrect";
        }
      )
  }

}
