package com.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.demo.model.Product_info;
import com.google.gson.Gson;

@Component
public class GsonTest extends RewardOrderApplicationTests{

	
	@Test
	public void testFromJson() {
		String message = "{\"productId\":\"1\",\"productName\":\"burger\",\"productPrice\":5.20,\"productStock\":70}";
		Gson gson = new Gson();
		Product_info productInfo = gson.fromJson(message, Product_info.class);
		assertTrue(productInfo.getProductName().equals("burger"));
		
	}
}
