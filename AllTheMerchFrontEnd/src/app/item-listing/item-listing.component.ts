import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-item-listing',
  templateUrl: './item-listing.component.html',
  styleUrls: ['./item-listing.component.css']
})
export class ItemListingComponent implements OnInit {

  public itemId;
  public item;

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(){
    this.itemId = this.router.url.substring(this.router.url.lastIndexOf('/') + 1);
    this.getShopItem();
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
