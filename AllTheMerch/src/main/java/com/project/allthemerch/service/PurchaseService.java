package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.Purchase;
import com.project.allthemerch.repo.PurchaseDao;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseDao purchaseDao;
	
	public Purchase save(Purchase purchase) {
		return purchaseDao.save(purchase);
	}
	
	public List<Purchase> findAll(){
		return purchaseDao.findAll();
	}
	
	public void delete(int id) {
		purchaseDao.deleteByPurchaseId(id);
	}
	
	public Purchase findByPurchaseId(int id) {
		return purchaseDao.findById(id);
	}
}
