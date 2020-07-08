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
@Table(name = "purchase_item")
public class PurchaseItem {

	@Id
	@Column(name="purchase_item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchaseItemId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="purchase_id")
	private Purchase purchase;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id")
	private Item item;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="purchase_price")
	private double purchase_price;

	public PurchaseItem() {
		
	}

	public PurchaseItem(int purchaseItemId, Purchase purchase, Item item, int quantity, double purchase_price) {
		this.purchaseItemId = purchaseItemId;
		this.purchase = purchase;
		this.item = item;
		this.quantity = quantity;
		this.purchase_price = purchase_price;
	}
	
	public PurchaseItem(Purchase purchase, Item item, int quantity, double purchase_price) {
		this.purchase = purchase;
		this.item = item;
		this.quantity = quantity;
		this.purchase_price = purchase_price;
	}

	public int getPurchaseItemId() {
		return purchaseItemId;
	}

	public void setPurchaseItemId(int purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}

	public Purchase getPurchases() {
		return purchase;
	}

	public void setPurchases(Purchase purchase) {
		this.purchase = purchase;
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
		return "PurchaseItem [purchaseItemId=" + purchaseItemId + ", purchase=" + purchase + ", item=" + item
				+ ", quantity=" + quantity + ", purchase_price=" + purchase_price + "]";
	}
	
}
