package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.Artist;
import com.project.allthemerch.model.Item;

@Transactional 
public interface ItemDao extends CrudRepository<Item, Integer>{
	
	public List<Item> findAll();
	public void deleteByItemId(int id);
	public List<Item> findByArtist(Artist a);
	public Item findById(int id);

}
