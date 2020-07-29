import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ShopComponent } from './shop/shop.component';
import { ItemListingComponent } from './item-listing/item-listing.component';
import { MerchComponent } from './merch/merch.component';
import { CartComponent } from './cart/cart.component';

const routes: Routes = [
  {path: 'shop', component: ShopComponent, children:[
    {path: 'item', component: ItemListingComponent, children:[
      {path: '', component:ShopComponent},
      {path: '**', component:ShopComponent}
    ]},
    {path: 'merch', component: MerchComponent},
    {path: '', component: MerchComponent}, 
    {path: '**', component: MerchComponent}
  ]},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo:'shop', pathMatch:'prefix'}, 
  {path: '**', redirectTo:'shop', pathMatch:'prefix'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
