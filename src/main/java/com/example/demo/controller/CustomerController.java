package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping
	public List<Customer> findAll() {
		return (List<Customer>) customerService.findAll();
	}
	
	@GetMapping("/{customerId}")
	public Customer findById(@PathVariable("customerId") int customerId) {
		return customerService.findById(customerId);
	}
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(customer.getCustomerId());
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping("/{customerId}")
	public Customer updateById(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
		customer.setCustomerId(customerId);
		return customerService.saveCustomer(customer);
	}
	
	@DeleteMapping
	public void deleteCustomerList(@RequestBody List<Customer> customers) {
		customerService.deleteCustomerList(customers);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomerList(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerService.findById(customerId));
	}

}
