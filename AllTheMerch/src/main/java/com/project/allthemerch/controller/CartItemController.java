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

import com.project.allthemerch.model.CartItem;
import com.project.allthemerch.service.CartItemService;

@RestController
@RequestMapping("/api/cartitems")
@CrossOrigin
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;
	
	@PostMapping
	public CartItem createCartItem(@RequestBody CartItem cartItem) {
		cartItem.setCartItemId(0);
		return cartItemService.save(cartItem);
	}
	
	@GetMapping
	public List<CartItem> getCartItems(){
		return cartItemService.findAll();
	}
	
	@GetMapping("/{id}") 
	public CartItem getCartItemById(@PathVariable(value = "id") int cartItemId) {
		return cartItemService.findByCartItemId(cartItemId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCartItem(@PathVariable(value = "id") int cartItemId) {
		cartItemService.delete(cartItemId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CartItem> putCartItem(@RequestBody CartItem cartItem, @PathVariable(value = "id") int cartItemId) {
		System.out.println(cartItem.getCartItemId());
		if(cartItem.getCartItemId() > 0 && cartItem.getCartItemId() != cartItemId) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		cartItem.setCartItemId(cartItemId);
		return new ResponseEntity<>(cartItemService.save(cartItem), HttpStatus.OK);
	}
	
}
