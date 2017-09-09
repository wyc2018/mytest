package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerDao {

	void saveCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
	
	Customer findCustomerById(Long cust_id);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(Long cust_id);
	//nihao
}
