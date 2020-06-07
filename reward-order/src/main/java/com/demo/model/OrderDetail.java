package com.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class OrderDetail {
	@Id
	private String detailId;
	
	private String orderId;
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer productQuantity;
}
