package com.springbootjwt.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootjwt.model.Product;

//inherits a set of CRUD (Create, Read, Update, Delete) operations 
@Repository
public interface productRepository extends JpaRepository<Product,Integer>
	{
		//to annotate repository interface methods
		@Query("select p from Product p where p.name=?1")
		List<Product> getProductByName(String name);
	}
	