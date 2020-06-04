package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product_category {
	@Id
	@GeneratedValue
	private Integer categoryId;
	
	private String categoryName;
	private Integer categoryType;
	private Date createTime;
	private Date updateTime;
	
}
