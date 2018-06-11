import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Stream} from "./stream";

@Injectable()
export class StreamService {

  private apiUrl = 'http://localhost:8080/api/streams'

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Stream[]> {
    return this.httpClient.get<Stream[]>(this.apiUrl);
  }
}
