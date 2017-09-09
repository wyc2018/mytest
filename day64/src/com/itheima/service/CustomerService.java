package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerService {

	void saveCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
	
	Customer findCustomerById(Long cust_id);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(Long cust_id);
}
