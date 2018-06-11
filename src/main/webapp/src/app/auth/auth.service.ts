import { Injectable } from '@angular/core';
import {User} from "./User";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";


@Injectable()
export class AuthService {
  API_URL: "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  logIn(username:String, password: String): Observable<any>{
    console.log(username + " " + password);
    const headers = new HttpHeaders();
    // headers.append('Accept', 'application/json')
    // headers.append("Content-Type", "application/x-www-form-urlencoded");
    // creating base64 encoded String from user name and password
    // var base64Credential: string =
    headers.append("Authorization", "Basic YWRtaW46YWRtaW5pc3RyYXRvcg==");// + btoa( "admin" + ':' + "administrator"));

    return this.http.get( "http://localhost:8080/api" + "/login", {headers: headers});
    // {
    //     var response: Response;
    //     // login successful if there's a jwt token in the response
    //     let user = response.json();// the returned user object is a principal object
    //     console.log("dupa, dupa");
    //     if (user) {
    //       // store user details  in local storage to keep user logged in between page refreshes
    //       localStorage.setItem('currentUser', JSON.stringify(user));
    //       console.log("dupa, dupa");
    //     } else {
    //
    //     }
    // };
  }

  logOut(): Observable<any> {
    // remove user from local storage to log user out
    return this.http.post(this.API_URL + "logout", {})
    {
      var response: Response;
      localStorage.removeItem('currentUser');
    };
  }

}
