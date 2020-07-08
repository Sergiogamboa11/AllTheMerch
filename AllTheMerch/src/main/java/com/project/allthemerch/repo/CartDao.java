package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.Cart;

@Transactional
public interface CartDao extends CrudRepository<Cart, Integer>{
	public List<Cart> findAll();
	public void deleteByCartId(int id);
	public Cart findById(int id);
}
