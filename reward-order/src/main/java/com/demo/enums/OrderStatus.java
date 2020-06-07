package com.demo.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
	NEW(0,"new order"),
	COMPLETED(1,"order completed"),
	CANCEL(2,"order canceled"),
	;
	
	private Integer code;
	private String message;
	
	OrderStatus(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
}
