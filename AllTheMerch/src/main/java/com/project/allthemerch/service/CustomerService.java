package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.Customer;
import com.project.allthemerch.repo.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}
	
	public List<Customer> findAll(){
		return customerDao.findAll();
	}
	
	public void delete(int id) {
		customerDao.deleteByCustomerId(id);
	}
	
	public Customer findByCustomerId(int id) {
		return customerDao.findById(id);
	}
	
	public Customer findByCustomerUsernameAndPassword(String username, String password) {
		return customerDao.findByUsernameAndPassword(username, password);
	}
}
