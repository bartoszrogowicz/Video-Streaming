import { Injectable } from '@angular/core';

import {Observable} from "rxjs/Observable";
import {Stream} from "./stream";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class StreamService {

  private apiUrl = 'http://localhost:8080/api/streams'

  constructor(private http: HttpClient) { }

  public getHeaders() {
    let headers;
    if (localStorage.getItem('userToken') != null) {
      console.log("token ustawiony");
      console.log(localStorage.getItem('userToken').toString())
      headers = new HttpHeaders(
        {
          "Accept": "application/json",
          "Content-Type": "application/json",
          "Authorization": "Bearer " + localStorage.getItem('userToken')
        });
       } else {
        headers = new HttpHeaders(
          {
            "Accept": "application/json",
            "Content-Type": "application/json",
          });
      }

      return headers;
  }

  findAllStreams(): Observable<any>  {
    console.log("GEt headers" + this.getHeaders().get("Authorization"));
    return this.http.get( this.apiUrl,{headers: this.getHeaders()});
  }

  deleteStreamById(id: number) {
    const url = this.apiUrl + '/' + id;
    return this.http.delete(url);
  }

 /* updateUser(): Observable<User> {
    return this.httpClient.put<User>(this.apiUrl,user);
  }*/
}


