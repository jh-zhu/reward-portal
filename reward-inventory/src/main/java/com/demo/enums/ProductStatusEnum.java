package com.demo.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
	UP(0,"available"),
	DOWN (1, "not availiable"),
	;
	
	private Integer code;
	
	private String message;
	
	ProductStatusEnum(Integer code, String message){
		this.code = code;
		this.message = message;
	}
	
	
}
