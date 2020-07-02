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
import javax.persistence.Table;

@Entity
@Table(name = "Cart_Items")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartItemsId;
	
//	@Column
//	@JoinColumn(name="customer_id")
//	private Customer customer;
	
	@OneToMany (fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	private List<Item> item;
	
	@Column
	private int quantity;
	
}
