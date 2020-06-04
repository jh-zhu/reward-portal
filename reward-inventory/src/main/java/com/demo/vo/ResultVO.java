package com.demo.vo;

import java.util.List;

import lombok.Data;


/*
 * Http request return object
 * 
 * */

@Data
public class ResultVO<T> {
	// return code
	private Integer code;
	
	// return info
	private String message;
	
	// context
	private T data;
}
