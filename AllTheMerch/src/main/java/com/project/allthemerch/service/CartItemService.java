package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.CartItem;
import com.project.allthemerch.repo.CartItemDao;

@Service
public class CartItemService {

	@Autowired
	private CartItemDao cartItemDao;
	
	public CartItem save(CartItem cartItem) {
		return cartItemDao.save(cartItem);
	}
	
	public List<CartItem> findAll(){
		return cartItemDao.findAll();
	}
	
	public void delete(int id) {
		cartItemDao.deleteByCartItemId(id);
	}
	
	public CartItem findByCartItemId(int id) {
		return cartItemDao.findById(id);
	}
	
}
