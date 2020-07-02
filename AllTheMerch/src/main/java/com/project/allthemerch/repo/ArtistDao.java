package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.Artist;

@Transactional
public interface ArtistDao extends CrudRepository<Artist, Integer> {
	public List<Artist> findAll();
	public void deleteByArtistId(int id);
	public Artist findById(int id);
}
