package com.project.allthemerch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.allthemerch.model.Artist;
import com.project.allthemerch.service.ArtistService;

@RestController
@RequestMapping("/api/artists")
@CrossOrigin
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@PostMapping
	public @ResponseBody Artist createArtist(@RequestBody Artist artist) {
		artist.setArtistId(0);
		return artistService.save(artist);
	}
	
	@GetMapping
	public @ResponseBody List<Artist> getArtists(){
		return artistService.findAll();
	}
	
	@GetMapping("/{id}") 
	public @ResponseBody Artist getArtistById(@PathVariable(value = "id") int artistId) {
		return artistService.findByArtistId(artistId);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody void deleteArtist(@RequestBody int id) {
		artistService.delete(id);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Artist> putArtist(@RequestBody Artist artist, @PathVariable(value = "id") int artistId) {
		System.out.println(artist.getArtistId());
		if(artist.getArtistId() > 0 && artist.getArtistId() != artistId) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		artist.setArtistId(artistId);
		return new ResponseEntity<>(artistService.save(artist), HttpStatus.OK);
	}
	
}
