import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CartItem } from '../models/cart-item.model';
import { FormGroup, FormControl } from '@angular/forms';
import { ItemService } from '../services/item.service';
import { CartItemService } from '../services/cart-item.service';

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

  constructor(private router: Router, private itemService: ItemService, private cartItemService: CartItemService) { }

  ngOnInit() {
    this.itemId = this.router.url.substring(this.router.url.lastIndexOf('/') + 1);
    this.getShopItem();
  }

  addToCart() {

    this.cartItem.cartId = 1; //This is hardcoded for now
    this.cartItem.quantity = this.registerForm.get("quantityForm").value;
    if (this.cartItem.quantity == undefined || this.cartItem.quantity < 1)
      this.cartItem.quantity = 1;
    this.cartItem.itemId = this.itemId;
    console.log(this.cartItem);

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
