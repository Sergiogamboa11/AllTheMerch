package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.PurchaseItem;

@Transactional
public interface PurchaseItemDao extends CrudRepository<PurchaseItem, Integer>{
	public List<PurchaseItem> findAll();
	public void deleteByPurchaseItemId(int id);
	public PurchaseItem findById(int id);
}
