package com.project.allthemerch.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchases")
public class Purchases {

	@Id 
	@Column(name="purchase_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purcahseId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name="purchase_date")
	private Date purchaseDate;

	public Purchases() {
		
	}

	public Purchases(int purcahseId, Customer customer, Date purchaseDate) {
		super();
		this.purcahseId = purcahseId;
		this.customer = customer;
		this.purchaseDate = purchaseDate;
	}
	
	public Purchases(Customer customer, Date purchaseDate) {
		super();
		this.customer = customer;
		this.purchaseDate = purchaseDate;
	}

	public int getPurcahseId() {
		return purcahseId;
	}

	public void setPurcahseId(int purcahseId) {
		this.purcahseId = purcahseId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Purchases [purcahseId=" + purcahseId + ", purchaseDate=" + purchaseDate + "]";
	}
		
}
