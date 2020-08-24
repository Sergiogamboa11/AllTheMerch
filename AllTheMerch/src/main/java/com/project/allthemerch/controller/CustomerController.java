package com.project.allthemerch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.allthemerch.model.Customer;
import com.project.allthemerch.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(0);
		return customerService.save(customer);
	}
	
	@GetMapping
	public List<Customer> getCustomers(){
		return customerService.findAll();
	}
	
	@GetMapping("/{id}") 
	public Customer getCustomersByid(@PathVariable(value = "id") int customerId) {
		return customerService.findByCustomerId(customerId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable(value = "id") int customerId) {
		customerService.delete(customerId);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable(value = "id") int customerId) {
		System.out.println(customer.getCustomerId());
		if(customer.getCustomerId() > 0 && customer.getCustomerId() != customerId) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		customer.setCustomerId(customerId);
		return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
	}
	
}
