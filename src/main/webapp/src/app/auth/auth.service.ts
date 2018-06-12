import { Injectable } from '@angular/core';
import {User} from "./User";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import { map } from "rxjs/operators";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {StreamService} from "../streams/stream.service";

const API_URL: String = "http://localhost:8080/api";

@Injectable()
export class AuthService {

  constructor(private http: HttpClient, private router: Router,
              private stream: StreamService) { }

  logIn(username:String, password: String) {
    console.log(username + " " + password);
    const headers = new HttpHeaders();



    const token_cred = {
      'username': username,
      'password': password
    }

    return this.http.post( API_URL + "/login", token_cred, {headers:this.stream.getHeaders()});
    //   .pipe(
    //   map((response: Response) => {
    //     console.log(response)
    //     // login successful if there's a jwt token in the response
    //     let token = response.json()// the returned user object is a principal object
    //
    //       // store user details  in local storage to keep user logged in between page refreshes
    //     localStorage.setItem('token', JSON.stringify(token));
    //     console.log("saved")
    //
    //   }
    // ));

  }



  // logOut():  {
  //
  // }
    // remove user from local storage to log user out
      //localS
      //localStorage.removeItem('token');

}
