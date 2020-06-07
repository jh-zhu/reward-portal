package com.demo.dto;

import lombok.Data;

@Data
public class CartDTO {
	// product id
	private String productId;
	
	//product quantity
	private Integer productQuantity;
	
	public CartDTO(){
		
	}
	
	public CartDTO(String Id, Integer Quantity) {
		this.productId = Id;
		this.productQuantity = Quantity;
	}
}
