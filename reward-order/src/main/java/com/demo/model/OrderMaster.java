package com.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OrderMaster {
	@Id
	private String orderId;
	
	private String buyerName;
	private String buyerOpenid;
	private BigDecimal orderAmount;
	private Integer orderStatus;
	
	
}
