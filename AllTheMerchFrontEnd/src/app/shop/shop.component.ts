import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item }from '../models/item.model';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  public items;

  constructor(private http: HttpClient) { }

  getShopItems(){
    this.http.get('http://localhost:9025/api/items').toPromise().then(data => {
      if(data == null || data == undefined){
      } else{
        // console.log(data);
        this.items = data;
        console.log(this.items);
      }
    });
  }

  ngOnInit(): void {
    this.getShopItems();
  }

}
