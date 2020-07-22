import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-merch',
  templateUrl: './merch.component.html',
  styleUrls: ['./merch.component.css']
})
export class MerchComponent implements OnInit {

  public items;

  getShopItems(){
    this.http.get('http://localhost:9025/api/items').toPromise().then(data => {
      if(data == null || data == undefined){
      } else{
        this.items = data;
      }
    });
  }

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getShopItems();
  }

}
