package com.CustomerManagement.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerManagement.repos.*;
import com.CustomerManagement.entity.*;
import lombok.*;


@Service
@RequiredArgsConstructor
public class CustomerService 
{
	private final CustomerRepos customerrepos;
	
	public Customer save(Customer customer) {
		return customerrepos.save(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return customerrepos.findAll();
	}
	
	public Customer getCustomerById(Long id)
	{
		return customerrepos.findById(id).orElseThrow(()
		-> new RuntimeException("Customer found for the id "+id));	
	}
	
	public Customer update(Customer customer,Long id)
	{
		Customer existingcustomer=customerrepos.findById(id).get();
		existingcustomer.setPhone(customer.getPhone());
//		existingcustomer.setLastname(customer.getLastname());
		existingcustomer.setEmail(customer.getEmail());
		existingcustomer.setName(customer.getName());
//		existingcustomer.setOrders(customer.getOrders());
		
		return customerrepos.save(existingcustomer);
	}
	
	public void delete(Long id) {
		Customer existingcustomer = customerrepos.findById(id).get();
		customerrepos.delete(existingcustomer);
		
	}
}
