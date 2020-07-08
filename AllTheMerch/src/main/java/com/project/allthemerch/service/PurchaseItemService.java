package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.PurchaseItem;
import com.project.allthemerch.repo.PurchaseItemDao;

@Service
public class PurchaseItemService {
	
	@Autowired
	private PurchaseItemDao purchaseItemDao;
	
	public PurchaseItem save(PurchaseItem purchaseItem) {
		return purchaseItemDao.save(purchaseItem);
	}
	
	public List<PurchaseItem> findAll(){
		return purchaseItemDao.findAll();
	}
	
	public void delete(int id) {
		purchaseItemDao.deleteByPurchaseItemId(id);
	}
	
	public PurchaseItem findByPurchaseItemId(int id) {
		return purchaseItemDao.findById(id);
	}

}
