package com.demo.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class OrderForm {
	
	@NotEmpty(message = "please enter name")
	private String name;
	
	@NotEmpty(message = "please enter buyer openid")
	private String openid;
	
	@NotEmpty(message = "cart cannot be empty")
	private String items;
}
