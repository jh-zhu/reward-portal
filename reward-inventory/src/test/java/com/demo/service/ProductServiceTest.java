package com.demo.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.model.CartDTO;
import com.demo.model.Product_info;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService productService;
	@Test
	public void findUpAll() {
		List<Product_info> list = productService.findUpAll();
		Assert.assertTrue(list.size()>0);
	}
	
	@Test
	public void findList() {
		List<Product_info> list = productService.findList(Arrays.asList("1","2","3"));
		assertTrue(list.size()>0);
	}
	
	
	@Test
	public void decreaseStock() {
		CartDTO cartDTO  = new CartDTO();
		cartDTO.setProductId("1");
		cartDTO.setProductQuantity(2);
		productService.decreaseStock(Arrays.asList(cartDTO));
	}
	
}
