package com.demo.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ProductInfoMsg {
	private String productId;
	
	private String productName;
	private BigDecimal productPrice;
	private Integer productStock;
	private String productDescription;
	private Integer productStatus;
	private Integer categoryType;
}
