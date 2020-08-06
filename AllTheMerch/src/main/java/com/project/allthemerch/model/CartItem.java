package com.project.allthemerch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cart_Item")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "cart_item_seq")
	@SequenceGenerator(name = "cart_item_seq", 
	initialValue = 2)
	private int cartItemId;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;

	@Column
	private int quantity;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItem() {
	}

	public CartItem(int cartItemId, Cart cart, Item item, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.cart = cart;
		this.item = item;
		this.quantity = quantity;
	}

	public CartItem(Cart cart, Item item, int quantity) {
		super();
		this.cart = cart;
		this.item = item;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cart=" + cart + ", item=" + item + ", quantity=" + quantity
				+ "]";
	}

}
