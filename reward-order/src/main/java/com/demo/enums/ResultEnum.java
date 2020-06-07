package com.demo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	PARAM_ERROR(1,"invalid parameter"),
	CART_EMPTY(2,"empty cart")
	
	;
	
	private Integer code;
	private String message;
	
	ResultEnum(Integer code, String message){
		this.code = code;
		this.message = message;
	}
}
