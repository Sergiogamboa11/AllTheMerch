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
	
	public Artist() {
	}

	public Artist(int artistId, String artistName, String artistDescription) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistDescription = artistDescription;
	}
	
	public Artist(String artistName, String artistDescription) {
		super();
		this.artistName = artistName;
		this.artistDescription = artistDescription;
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


	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", artistDescription="
				+ artistDescription + "]";
	}
	
}
