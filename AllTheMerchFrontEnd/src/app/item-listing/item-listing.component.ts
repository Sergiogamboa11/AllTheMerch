import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CartItem } from '../models/cart-item.model';
import { FormGroup, FormControl } from '@angular/forms';
import { ItemService } from '../services/item.service';
import { CartItemService } from '../services/cart-item.service';
import { Cart } from '../models/cart.model';
import { Item } from '../models/item.model';

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
    quantityForm: new FormControl('1')
  });

  constructor(private router: Router, private itemService: ItemService, private cartItemService: CartItemService) { }

  ngOnInit() {
    this.itemId = this.router.url.substring(this.router.url.lastIndexOf('/') + 1);
    this.getShopItem();
  }

  addToCart() {
    this.cartItem.quantity = this.registerForm.get("quantityForm").value;
    
    this.cartItem.cart = new Cart();
    this.cartItem.cart.cartId = 1; //This is hardcoded for now

    this.cartItem.item = new Item();
    this.cartItem.item.itemId = this.itemId;
    // console.log(this.cartItem);

    this.cartItemService.post(this.cartItem)
      .subscribe(response => {
        console.log(response);
      });
  }

  getShopItem() {
    this.itemService.getItem(this.itemId)
      .subscribe(response => {
        console.log(response);
        this.item = response;
      });
  }


}
