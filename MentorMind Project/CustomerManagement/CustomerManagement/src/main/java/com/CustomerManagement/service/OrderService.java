package com.CustomerManagement.service;
import com.CustomerManagement.repos.*;
import com.CustomerManagement.entity.*;
import lombok.*;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService 
{
	private final OrderRepos orderrepos;
	
	public Order save(Order order) {
		return orderrepos.save(order);
	}
	
	public List<Order> getAllOrder(){
		return orderrepos.findAll();
	}
	
	public Order getOrderById(Long id)
	{
		return orderrepos.findById(id).orElseThrow(()
		-> new RuntimeException("Customer found for the id "+id));	
	}
	
	public Order update(Order order,Long id)
	{
		Order existingorder=orderrepos.findById(id).get();
		existingorder.setQuantity(order.getQuantity());
		existingorder.setTotal_price(order.getTotal_price());
		existingorder.setQuantity(order.getQuantity());
		
		return orderrepos.save(existingorder);
	}
	
	public void delete(Long id) {
		Order existingorder = orderrepos.findById(id).get();
		orderrepos.delete(existingorder);
		
	}
}
