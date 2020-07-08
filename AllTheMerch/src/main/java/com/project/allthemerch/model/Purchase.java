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
@Table(name="purchase")
public class Purchase {

	@Id 
	@Column(name="purchase_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchaseId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name="purchase_date")
	private Date purchaseDate;

	public Purchase() {
		
	}

	public Purchase(int purchaseId, Customer customer, Date purchaseDate) {
		super();
		this.purchaseId = purchaseId;
		this.customer = customer;
		this.purchaseDate = purchaseDate;
	}
	
	public Purchase(Customer customer, Date purchaseDate) {
		super();
		this.customer = customer;
		this.purchaseDate = purchaseDate;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
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
		return "Purchase [purchaseId=" + purchaseId + ", purchaseDate=" + purchaseDate + "]";
	}
		
}
