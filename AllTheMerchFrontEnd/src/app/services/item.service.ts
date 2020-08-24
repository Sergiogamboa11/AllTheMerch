import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private url = "http://localhost:9025/api/items/";

  constructor(private httpClient: HttpClient) { }

  getItem(id){
    return this.httpClient.get(this.url + id);
  }

  getItems(){
    return this.httpClient.get(this.url);
  }

  post(payload){
    return this.httpClient.post(this.url, payload);
  }

}
