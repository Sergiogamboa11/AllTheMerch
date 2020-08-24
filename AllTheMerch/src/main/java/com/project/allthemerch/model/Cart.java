package com.project.allthemerch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	
	@OneToOne
	@JoinColumn (name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "cart")
	@JsonManagedReference
    private List<CartItem> cartItems;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Cart() {
	}

	public Cart(int cartId, Customer customer) {
		super();
		this.cartId = cartId;
		this.customer = customer;
	}
	
	public Cart(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + "]";
	}
	
}
