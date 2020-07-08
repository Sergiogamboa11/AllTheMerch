package com.project.allthemerch.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.Purchase;

public interface PurchaseDao extends CrudRepository<Purchase, Integer>{
	public List<Purchase> findAll();
	public void deleteByPurchaseId(int id);
	public Purchase findById(int id);
}
