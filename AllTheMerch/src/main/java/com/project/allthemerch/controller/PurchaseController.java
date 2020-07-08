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

import com.project.allthemerch.model.Purchase;
import com.project.allthemerch.service.PurchaseService;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping
	public @ResponseBody Purchase createPurchase(@RequestBody Purchase purchase) {
		purchase.setPurchaseId(0);
		return purchaseService.save(purchase);
	}
	
	@GetMapping
	public @ResponseBody List<Purchase> getPurchases(){
		return purchaseService.findAll();
	}
	
	@GetMapping("/{id}") 
	public @ResponseBody Purchase getPurchaseById(@PathVariable(value = "id") int purchaseId) {
		return purchaseService.findByPurchaseId(purchaseId);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody void deletePurchase(@PathVariable(value = "id") int purchaseId) {
		purchaseService.delete(purchaseId);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Purchase> putPurchase(@RequestBody Purchase purchase, @PathVariable(value = "id") int purchaseId) {
		System.out.println(purchase.getPurchaseId());
		if(purchase.getPurchaseId() > 0 && purchase.getPurchaseId() != purchaseId) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		purchase.setPurchaseId(purchaseId);
		return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.OK);
	}
	
}
