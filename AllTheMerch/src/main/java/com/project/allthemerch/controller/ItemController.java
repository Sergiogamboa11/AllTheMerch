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
import org.springframework.web.bind.annotation.RestController;

import com.project.allthemerch.model.Item;
import com.project.allthemerch.service.ItemService;

@RestController
@RequestMapping("/api/items")
@CrossOrigin
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping
	public Item createItem(@RequestBody Item item) {
		item.setItemId(0);
		return itemService.save(item);
	}
	
	@GetMapping
	public List<Item> getItems() {
		return itemService.findAll();
	}

	@GetMapping("/{id}") 
	public Item getCustomersByid(@PathVariable(value = "id") int itemId) {
		return itemService.findByItemId(itemId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable(value = "id") int itemId) {
		itemService.delete(itemId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> putItem(@RequestBody Item item, @PathVariable(value = "id") int itemId) {
		System.out.println(item.getItemId());
		if(item.getItemId() > 0 && item.getItemId() != itemId) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		item.setItemId(itemId);
		return new ResponseEntity<>(itemService.save(item), HttpStatus.OK);
	}
}
