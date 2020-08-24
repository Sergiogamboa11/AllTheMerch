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

import com.project.allthemerch.model.PurchaseItem;
import com.project.allthemerch.service.PurchaseItemService;

@RestController
@RequestMapping("/api/controllers")
@CrossOrigin
public class PurchaseItemController {

	@Autowired
	private PurchaseItemService purchaseItemService;
	
	@PostMapping
	public PurchaseItem createPurchaseItem(@RequestBody PurchaseItem purchaseItem) {
		purchaseItem.setPurchaseItemId(0);
		return purchaseItemService.save(purchaseItem);
	}
	
	@GetMapping
	public List<PurchaseItem> getPurchaseItems(){
		return purchaseItemService.findAll();
	}
	
	@GetMapping("/{id}") 
	public PurchaseItem getPurchaseItemById(@PathVariable(value = "id") int purchaseItemId) {
		return purchaseItemService.findByPurchaseItemId(purchaseItemId);
	}
	
	@DeleteMapping("/{id}")
	public void deletePurchaseItem(@PathVariable(value = "id") int purchaseItemId) {
		purchaseItemService.delete(purchaseItemId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PurchaseItem> purPurchaseItem(@RequestBody PurchaseItem purchaseItem, @PathVariable(value = "id") int purchaseItemId) {
		System.out.println(purchaseItem.getPurchaseItemId());
		if(purchaseItem.getPurchaseItemId() > 0 &&purchaseItem.getPurchaseItemId() != purchaseItemId) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		purchaseItem.setPurchaseItemId(purchaseItemId);
		return new ResponseEntity<>(purchaseItemService.save(purchaseItem), HttpStatus.OK);
	}
	
}
