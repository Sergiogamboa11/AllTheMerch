package com.project.allthemerch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart_Items")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartItemsId;
	
	@OneToOne
	@JoinColumn(name="cart_id")
	private Customer customer;
	
	@OneToMany (fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	private List<Item> item;
	
	@Column
	private int quantity;

	public int getCartItemsId() {
		return cartItemsId;
	}

	public void setCartItemsId(int cartItemsId) {
		this.cartItemsId = cartItemsId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public CartItems(int cartItemsId, Customer customer, List<Item> item, int quantity) {
		super();
		this.cartItemsId = cartItemsId;
		this.customer = customer;
		this.item = item;
		this.quantity = quantity;
	}
	
	public CartItems(Customer customer, List<Item> item, int quantity) {
		super();
		this.customer = customer;
		this.item = item;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItems [cartItemsId=" + cartItemsId + ", customer=" + customer + ", item=" + item + ", quantity="
				+ quantity + "]";
	}
	
}
