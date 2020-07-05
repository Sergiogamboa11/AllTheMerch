package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.Artist;
import com.project.allthemerch.model.Item;
import com.project.allthemerch.repo.ItemDao;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	public Item save(Item item) {
		return itemDao.save(item);
	}
	
	public List<Item> findAll() {
		return itemDao.findAll();
	}
	
	public Item findByItemId(int id) {
		return itemDao.findById(id);
	}
	
	public List<Item> findByArtist(Artist a) {
		return itemDao.findByArtist(a);
	}
	
	public void delete(int id) {
		itemDao.deleteByItemId(id);
	}

}
