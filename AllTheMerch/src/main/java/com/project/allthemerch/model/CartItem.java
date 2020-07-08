package com.project.allthemerch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cart_Item")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartItemId;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@OneToMany (fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	private List<Item> item;
	
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

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItem(int cartItemId, Cart cart, List<Item> item, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.cart = cart;
		this.item = item;
		this.quantity = quantity;
	}

	public CartItem(Cart cart, List<Item> item, int quantity) {
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