package com.demo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	PRODUCT_NOT_EXITS(1,"product is not available"),
	PRODUCT_STOCK_ERROR(2,"not enough stock"),
	;
	
	private Integer code;
	private String msg;
	
	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg= msg;
	}
	
	
}
