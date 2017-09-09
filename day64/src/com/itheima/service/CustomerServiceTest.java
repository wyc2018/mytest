package com.itheima.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.domain.Customer;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class CustomerServiceTest {

	@Autowired
	private CustomerService cs;
	@Test
	public void testSaveCustomer() {
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		CustomerService cs = (CustomerService) ac.getBean("customerService");*/
		Customer c = new Customer();
		c.setCust_name("袁泉");
		cs.saveCustomer(c);
	}

	@Test
	public void testFindAllCustomer() {
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		CustomerService cs = (CustomerService) ac.getBean("customerService");*/
		List<Customer> list = cs.findAllCustomer();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

	@Test
	public void testFindCustomerById() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		CustomerService cs = (CustomerService) ac.getBean("customerService");
		Customer customer = cs.findCustomerById(3L);
		System.out.println(customer);
	}

	@Test
	public void testUpdateCustomer() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		CustomerService cs = (CustomerService) ac.getBean("customerService");
		Customer customer = cs.findCustomerById(3L);
		customer.setCust_industry("diu");
		cs.updateCustomer(customer);
	}

	@Test
	public void testDeleteCustomer() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		CustomerService cs = (CustomerService) ac.getBean("customerService");
		cs.deleteCustomer(3L);
	}

}
