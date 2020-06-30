package com.project.allthemerch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.allthemerch.model.Artist;
import com.project.allthemerch.service.ArtistService;

@RestController
@RequestMapping("/artist")
@CrossOrigin
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@PostMapping
	public @ResponseBody Artist createArtist(@RequestBody Artist artist) {
		return artistService.save(artist);
	}
	
	@GetMapping
	public @ResponseBody List<Artist> getArtists(){
		return artistService.findAll();
	}
	
	@DeleteMapping
	public @ResponseBody void deleteArtist(@RequestBody int id) {
		artistService.delete(id);
	}
	
	@PutMapping
	public @ResponseBody Artist putArtist(@RequestBody Artist artist) {
		return artistService.save(artist);
	}
	
}
