package com.CustomerManagement.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerManagement.repos.*;
import com.CustomerManagement.entity.*;
import lombok.*;

@Service
@RequiredArgsConstructor
public class ProductService 
{
	private final ProductRepos productrepos;
	
	
	public Product save(Product product) {
		return productrepos.save(product);
	}
	
	public List<Product> getAllProduct(){
		return productrepos.findAll();
	}
	
	public Product getProductById(Long id)
	{
		return productrepos.findById(id).orElseThrow(()
		-> new RuntimeException("Customer found for the id "+id));	
	}
	
	public Product update(Product product,Long id)
	{
		Product existingproduct=productrepos.findById(id).get();
		existingproduct.setName(product.getName());
		existingproduct.setPrice(product.getPrice());
		existingproduct.setQuantity(product.getQuantity());
		existingproduct.setPrice(product.getPrice());
		
		return productrepos.save(existingproduct);
	}
	
	public void delete(Long id) {
		Product existingproduct = productrepos.findById(id).get();
		productrepos.delete(existingproduct);
		
	}

}
