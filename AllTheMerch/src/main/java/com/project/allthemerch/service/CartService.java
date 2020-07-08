package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.Cart;
import com.project.allthemerch.repo.CartDao;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public Cart save(Cart cart) {
		return cartDao.save(cart);
	}
	
	public List<Cart> findAll(){
		return cartDao.findAll();
	}
	
	public void delete(int id) {
		cartDao.deleteByCartId(id);
	}
	
	public Cart findByCartId(int id) {
		return cartDao.findById(id);
	}
}
