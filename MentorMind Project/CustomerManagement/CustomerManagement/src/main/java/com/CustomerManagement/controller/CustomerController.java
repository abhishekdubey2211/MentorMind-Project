package com.CustomerManagement.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.CustomerManagement.service.*;
import com.CustomerManagement.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerservice;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Customer create(@RequestBody Customer customer) {
		return customerservice.save(customer);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Customer> read(){
		return customerservice.getAllCustomer();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Customer read(@PathVariable Long id) {
		return customerservice.getCustomerById(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		customerservice.delete(id);
	}
	
	public Customer update(@PathVariable Long id,@RequestBody Customer customer) {
		return customerservice.update(customer, id);
	}
}
