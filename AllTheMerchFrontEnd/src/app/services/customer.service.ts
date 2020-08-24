import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private url = "http://localhost:9025/api/customers";

  constructor(private httpClient: HttpClient) { }

  post(payload){
    return this.httpClient.post(this.url, payload);
  }
}
