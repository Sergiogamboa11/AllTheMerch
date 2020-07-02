package com.project.allthemerch.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {
	
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="artist_id")
	private Artist artist;
	
	@Column
	private String type;
	
	@Column
	private int stock;
	
	@Column
	private LocalDate restockDate;

	@Column
	private String description;
	
	@Column
	private double price;
	
	public Item() {
	}

	public Item(int itemId, Artist artist, String type, int stock, LocalDate restockDate, String description,
			double price) {
		super();
		this.itemId = itemId;
		this.artist = artist;
		this.type = type;
		this.stock = stock;
		this.restockDate = restockDate;
		this.description = description;
		this.price = price;
	}
	
	public Item(Artist artist, String type, int stock, LocalDate restockDate, String description, double price) {
		super();
		this.artist = artist;
		this.type = type;
		this.stock = stock;
		this.restockDate = restockDate;
		this.description = description;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getRestockDate() {
		return restockDate;
	}

	public void setRestockDate(LocalDate restockDate) {
		this.restockDate = restockDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", artist=" + artist + ", type=" + type + ", stock=" + stock
				+ ", restockDate=" + restockDate + ", description=" + description + ", price=" + price + "]";
	}
	
}
