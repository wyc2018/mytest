package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerdao;

	public void setCustomerdao(CustomerDao customerdao) {
		this.customerdao = customerdao;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerdao.saveCustomer(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> list = customerdao.findAllCustomer();
		return list;
	}

	@Override
	public Customer findCustomerById(Long cust_id) {
		Customer c = customerdao.findCustomerById( cust_id);
		return c;
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerdao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long cust_id) {
		customerdao.deleteCustomer( cust_id);
	}

}
