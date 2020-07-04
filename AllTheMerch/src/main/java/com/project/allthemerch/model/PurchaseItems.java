package com.project.allthemerch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_items")
public class PurchaseItems {

	@Id
	@Column(name="purchase_items_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchaseItemsId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="purchase_id")
	private Purchases purchases;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id")
	private Item item;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="purchase_price")
	private double purchase_price;

	public PurchaseItems() {
		
	}

	public PurchaseItems(int purchaseItemsId, Purchases purchases, Item item, int quantity, double purchase_price) {
		this.purchaseItemsId = purchaseItemsId;
		this.purchases = purchases;
		this.item = item;
		this.quantity = quantity;
		this.purchase_price = purchase_price;
	}
	
	public PurchaseItems(Purchases purchases, Item item, int quantity, double purchase_price) {
		this.purchases = purchases;
		this.item = item;
		this.quantity = quantity;
		this.purchase_price = purchase_price;
	}

	public int getPurchaseItemsId() {
		return purchaseItemsId;
	}

	public void setPurchaseItemsId(int purchaseItemsId) {
		this.purchaseItemsId = purchaseItemsId;
	}

	public Purchases getPurchases() {
		return purchases;
	}

	public void setPurchases(Purchases purchases) {
		this.purchases = purchases;
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

	public double getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(double purchase_price) {
		this.purchase_price = purchase_price;
	}

	@Override
	public String toString() {
		return "PurchaseItems [purchaseItemsId=" + purchaseItemsId + ", purchases=" + purchases + ", item=" + item
				+ ", quantity=" + quantity + ", purchase_price=" + purchase_price + "]";
	}
	
}
