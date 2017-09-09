package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private QueryRunner qr ;
	
	public void setQr(QueryRunner qr) {
		this.qr = qr;
	}

	@Override
	public void saveCustomer(Customer customer) {
		try {
			Object[] params = {customer.getCust_name(),customer.getCust_source(),customer.getCust_industry(),customer.getCust_level(),customer.getCust_address(),customer.getCust_phone()};
			qr.update("insert into cst_customer values(null,?,?,?,?,?,?)",params);
		
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> list = null;
		try {
			list = qr.query("select * from cst_customer", new BeanListHandler<Customer>(Customer.class));
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public Customer findCustomerById(Long cust_id) {
		Customer customer = null;
		try {
			customer = qr.query("select * from cst_customer where cust_id=?", new BeanHandler<Customer>(Customer.class),cust_id);
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			Object[] param={customer.getCust_name(),customer.getCust_source(),customer.getCust_industry(),customer.getCust_level(),customer.getCust_address(),customer.getCust_phone(),customer.getCust_id()};;
			qr.update("update cst_customer set cust_name=?,cust_source=?,cust_industry=?,cust_level=?,cust_address=?,cust_phone=? where cust_id=?", param);
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteCustomer(Long cust_id) {
		try {
			qr.update("DELETE FROM cst_customer WHERE cust_id = ?",cust_id);
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}

}
