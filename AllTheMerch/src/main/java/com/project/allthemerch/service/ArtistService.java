package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.Artist;
import com.project.allthemerch.repo.ArtistDao;

@Service
public class ArtistService {

	@Autowired
	private ArtistDao artistDao;
	
	public Artist save(Artist artist) {
		return artistDao.save(artist);
	}
	
	public List<Artist> findAll(){
		return artistDao.findAll();
	}
	
	public void delete(int id) {
		artistDao.deleteByArtistId(id);
	}
	
	public Artist findByArtistId(int id) {
		return artistDao.findById(id);
	}
}
