package com.project.allthemerch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Artist")
public class Artist {

	@Id
	@Column(name = "artist_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int artistId;
	
	@Column 
	private String artistName;
	
	@Column
	private String artistDescription;
	
	@Column
	private String artistImage;
	
	public Artist() {
	}

	public Artist(int artistId, String artistName, String artistDescription, String artistImage) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistDescription = artistDescription;
		this.artistImage = artistImage;
	}

	public Artist(String artistName, String artistDescription, String artistImage) {
		super();
		this.artistName = artistName;
		this.artistDescription = artistDescription;
		this.artistImage = artistImage;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistDescription() {
		return artistDescription;
	}

	public void setArtistDescription(String artistDescription) {
		this.artistDescription = artistDescription;
	}

	public String getArtistImage() {
		return artistImage;
	}

	public void setArtistImage(String artistImage) {
		this.artistImage = artistImage;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", artistDescription="
				+ artistDescription + ", artistImage=" + artistImage + "]";
	}
	
}
