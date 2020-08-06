import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CartItem } from '../models/cart-item.model';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-item-listing',
  templateUrl: './item-listing.component.html',
  styleUrls: ['./item-listing.component.css']
})
export class ItemListingComponent implements OnInit {

  public itemId;
  public item;
  private cartItem: CartItem = new CartItem();

  registerForm = new FormGroup({
    quantityForm: new FormControl('')
  });

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(){
    this.itemId = this.router.url.substring(this.router.url.lastIndexOf('/') + 1);
    this.getShopItem();
  }

  addToCart(){

    this.cartItem.cartId = 1; //This is hardcoded for now
    this.cartItem.quantity = this.registerForm.get("quantityForm").value;
    console.log(this.cartItem.quantity);
    this.cartItem.itemId = this.itemId;

    this.http.post('http://localhost:9025/api/cartitems/', this.cartItem).toPromise().then(data => {
      
      if(data == null || data == undefined){
      } else{
      }
    });
  }

  getShopItem(){
    this.http.get('http://localhost:9025/api/items/' + this.itemId).toPromise().then(data => {
      if(data == null || data == undefined){
      } else{
        this.item = data;
        console.log(this.item);
      }
    });
  }

}
