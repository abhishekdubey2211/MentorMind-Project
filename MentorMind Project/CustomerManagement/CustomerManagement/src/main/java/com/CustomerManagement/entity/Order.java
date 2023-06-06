package com.CustomerManagement.entity;
import java.util.*;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Quantity")
	private Long quantity;
	
	@Column(name="TotalPrice")
	private double total_price;
    
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "product_id")
	    private Product product;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "customer_id")
	    private Customer customer;
}
