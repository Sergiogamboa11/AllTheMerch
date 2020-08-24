package com.project.allthemerch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.allthemerch.model.Customer;
import com.project.allthemerch.service.CustomerService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer getCustomersByid(@RequestBody Customer customer) {
		System.out.println(customer.getUsername() + " " + customer.getPassword());
		return customerService.findByCustomerUsernameAndPassword(customer.getUsername(), customer.getPassword());
	}
}
