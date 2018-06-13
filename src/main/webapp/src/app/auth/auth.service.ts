import { Injectable } from '@angular/core';

import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {StreamService} from "../streams/stream.service";

@Injectable()
export class AuthService {

  private apiUrl = 'http://localhost:8080/api'

  constructor(private http: HttpClient, private router: Router,
              private stream: StreamService) { }

  logIn(username:String, password: String) {
    const token_cred = {
      'username': username,
      'password': password
    }

    return this.http.post( this.apiUrl + "/login", token_cred, {headers:this.stream.getHeaders()});
  }

}
