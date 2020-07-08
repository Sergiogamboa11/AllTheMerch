package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.CartItem;

@Transactional
public interface CartItemDao extends CrudRepository<CartItem, Integer>{
	public List<CartItem> findAll();
	public void deleteByCartItemId(int id);
	public CartItem findById(int id);
}
