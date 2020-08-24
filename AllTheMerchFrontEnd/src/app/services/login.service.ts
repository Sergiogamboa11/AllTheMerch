import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = "http://localhost:9025/api/login";

  constructor(private httpClient: HttpClient) { }

  post(payload){
    return this.httpClient.post(this.url, payload);
  }
}
