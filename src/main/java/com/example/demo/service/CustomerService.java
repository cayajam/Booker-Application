package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

public class CustomerService {
	
	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Customer findById(int customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public void deleteCustomerList(List<Customer> customers) {
		customerRepository.deleteAll(customers);
	}

}
