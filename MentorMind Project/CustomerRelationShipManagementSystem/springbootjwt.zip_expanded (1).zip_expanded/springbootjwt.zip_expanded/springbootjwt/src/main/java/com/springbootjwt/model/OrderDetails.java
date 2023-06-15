package com.springbootjwt.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//this class is used to generate products order detail ordered by an user
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@OneToOne
	private Product product;

	@OneToOne
	private User user;
	
	private double total;

	private int quantity;

	private LocalDate orderDate=LocalDate.now();
	
	@NotNull
	@Column(length = 20)
	private String status;
}
