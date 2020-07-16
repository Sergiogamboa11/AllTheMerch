package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.Customer;

@Transactional
public interface CustomerDao extends CrudRepository<Customer, Integer>{
	public List<Customer> findAll();
	public void deleteByCustomerId(int id);
	public Customer findById(int id);
	public Customer findByUsernameAndPassword(String username, String password);
}
