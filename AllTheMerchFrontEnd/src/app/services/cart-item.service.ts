import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartItemService {

  private url = "http://localhost:9025/api/cartitems/";

  constructor(private httpClient: HttpClient) { }

  getCartItem(id){
    return this.httpClient.get(this.url + id);
  }

  getCartItems(){
    return this.httpClient.get(this.url);
  }

  post(payload){
    return this.httpClient.post(this.url, payload);
  }



}
