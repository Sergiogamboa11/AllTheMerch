import { Item } from './item.model';
import { Cart } from './cart.model';

export class CartItem {
    cart: Cart;
    item: Item;
    quantity: number;
  }