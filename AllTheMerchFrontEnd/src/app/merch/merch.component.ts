import { Component, OnInit } from '@angular/core';
import { ItemService } from '../services/item.service';

@Component({
  selector: 'app-merch',
  templateUrl: './merch.component.html',
  styleUrls: ['./merch.component.css']
})
export class MerchComponent implements OnInit {

  public items;

  constructor(private itemService: ItemService) { }

  getShopItems() {
    this.itemService.getItems()
      .subscribe(response => {
        console.log(response);
        this.items = response;
      });
  }

  ngOnInit(): void {
    this.getShopItems();
  }

}
