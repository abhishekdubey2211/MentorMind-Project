package com.springbootjwt.serviceimpl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjwt.model.OrderDetails;
import com.springbootjwt.model.Product;
import com.springbootjwt.model.User;
import com.springbootjwt.repository.OrderDetailsRepository;
import com.springbootjwt.repository.UserRepository;
import com.springbootjwt.repository.productRepository;
import com.springbootjwt.service.OrderDetailsService;

//allows to add business functionalities
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService
{
	//@Autowired used for automatic dependency injection
	@Autowired
	private productRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	 // method to get the period between the cancelDate and the orderDate   
	static int find(LocalDate  orderDate, LocalDate cancelDate)   
	    {   
	        Period difference = Period.between(orderDate, cancelDate);   
	        return difference.getDays();   
	    }  
	
	@Override
	//implementing an interface method to place an Order
	public String placeOrder(int productId, long userId, OrderDetails orderDetails) 
	{
		  String message;
		  Product p=productRepository.findById(productId).get();
		  User u=userRepository.findById(userId).get();
		  if(p.getStock()>orderDetails.getQuantity()) {
		  orderDetails.setTotal(p.getPrice()* orderDetails.getQuantity());
		  orderDetails.setProduct(p);
		  orderDetails.setUser(u);
		  orderDetails.setStatus("ORDER PLACED");
		  p.setStock(p.getStock()-orderDetails.getQuantity());
		  productRepository.save(p);
		  orderDetailsRepository.save(orderDetails);
		  message="Your order has been placed successfully!!\n Total amount="+orderDetails.getTotal()+""
		  		+ "\nProduct Name:"+p.getName()+"\n Product Quantity:"+orderDetails.getQuantity()+
		  		"\n Customer Name:"+u.getName()+""
		  		+ "\nYour product will be delivered within 7 working days";
		  }
		  else 
		  {
			  message="You can order only "+p.getStock()+" items";
		  }
		  return message;
	}
	
	
	//interface method to cancel an placed Order
	@Override
	public String cancelOrder(int orderId) 
	{
		String message;
		LocalDate cancelDate=LocalDate.now();
		//manual date set 
		//LocalDate cancelDate=LocalDate.of(2023,06,26);
		OrderDetails orderObj=orderDetailsRepository.findById(orderId).get();
		LocalDate orderDate=orderObj.getOrderDate();
		int days=find(orderDate,cancelDate);
		System.out.println(days);
		if(days<=7)
			{
			//update stock
			Product p=orderObj.getProduct();
			p.setStock(p.getStock()+orderObj.getQuantity());
			productRepository.save(p);
			
			orderObj.setStatus("CANCELLED");
			orderDetailsRepository.save(orderObj);
			//Cancel order
			//orderDetailsRepository.delete(orderObj);
			message="Order has been cancelled successfully";
			}
			else
			{
				message="You can't cancel order after 7days";
			}
		return message;
	}
}
