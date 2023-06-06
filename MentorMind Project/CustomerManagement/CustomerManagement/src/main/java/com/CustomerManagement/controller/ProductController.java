package com.CustomerManagement.controller;
import com.CustomerManagement.service.*;
import com.CustomerManagement.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController 
{
	@Autowired
	private ProductService productservice;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Product create(@RequestBody Product product) {
		return productservice.save(product);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Product> read(){
		return productservice.getAllProduct();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Product read(@PathVariable Long id) {
		return productservice.getProductById(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productservice.delete(id);
	}
	
	public Product update(@PathVariable Long id,@RequestBody Product product) {
		return productservice.update(product, id);
	}
	

}
