package com.springbootjwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//entity class takes all the product details for adding into the system by an admin
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(length = 25)	
	private String name;
	
	@NotNull
	@Column(length = 25)
	private String brand;

	@NotNull
	private int stock;

	@NotNull
	private double price;
	
	@Column(length= 25)
	@JsonIgnoreProperties
	private String status;
}
