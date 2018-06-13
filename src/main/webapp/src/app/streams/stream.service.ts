import { Injectable } from '@angular/core';

import {Observable} from "rxjs/Observable";
import {Stream} from "./stream";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class StreamService {

  private apiUrl = 'http://localhost:8080/api'

  constructor(private http: HttpClient) { }

  public getHeaders() {
    let headers;
    if (localStorage.getItem('userToken') != null) {
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
    return this.http.get( this.apiUrl + "/streams",{headers: this.getHeaders()});
  }

  deleteStreamById(id: number): Observable<any>{
    const url = this.apiUrl + '/streams/' + id;
    return this.http.delete(url, {headers: this.getHeaders()});
  }

  findOneStreamById(id: number): Observable<any> {
    const url = this.apiUrl + '/streams/' + id;
    return this.http.get(url, ({headers: this.getHeaders()}))
  }

  updateStream(stream: Stream): Observable<Stream> {
    return this.http.put<Stream>(this.apiUrl + "/streams", stream, {headers: this.getHeaders()});
  }

  createStream(stream: any): Observable<any> {
    return this.http.post(this.apiUrl + "/streams", stream, {headers:this.getHeaders()});
  }
}


