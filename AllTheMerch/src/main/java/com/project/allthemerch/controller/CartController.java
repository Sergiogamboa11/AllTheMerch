package com.project.allthemerch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.allthemerch.model.Cart;
import com.project.allthemerch.service.CartService;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	//No post or delete since we shouldn't be able to create new carts
	
	@GetMapping
	public @ResponseBody List<Cart> getCarts(){
		return cartService.findAll();
	}
	
	@GetMapping("/{id}") 
	public @ResponseBody Cart getCartById(@PathVariable(value = "id") int cartId) {
		return cartService.findByCartId(cartId);
	}
	
	@PutMapping("/{id}") //Needs to be changed so that we can't create more carts
	public @ResponseBody ResponseEntity<Cart> putCart(@RequestBody Cart cart, @PathVariable(value = "id") int cartId) {
		System.out.println(cart.getCartId());
		if(cart.getCartId() > 0 && cart.getCartId() != cartId) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		cart.setCartId(cartId);
		return new ResponseEntity<>(cartService.save(cart), HttpStatus.OK);
	}
	
}
