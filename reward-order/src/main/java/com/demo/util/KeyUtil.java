package com.demo.util;

import java.util.Random;

public class KeyUtil {
	/*
	 * Generate primary key 
	 * Format: time + random number
	 * 
	 * */
	
	
	public static synchronized String genUniqueKey() {
		Random random = new Random();
		Integer number  = random.nextInt(900000) + 100000;
		
		return System.currentTimeMillis() + String.valueOf(number);
	}
	
}
