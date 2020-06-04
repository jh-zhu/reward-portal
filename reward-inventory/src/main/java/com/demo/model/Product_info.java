package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Product_info {
	@Id
	private String productId;
	
	private String productName;
	private BigDecimal productPrice;
	private Integer productStock;
	private String productDescription;
	private Integer productStatus;
	private Integer categoryType;
	private Date createTime;
	private Date updateTime;

}
