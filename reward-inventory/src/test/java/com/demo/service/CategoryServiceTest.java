package com.demo.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.model.Product_category;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

	@Autowired
	CategoryService categoryService;
	@Test
	public void findByCategoryTypeIn() {
		List<Product_category> list = categoryService.findByCategoryTypeIn(Arrays.asList(11,22));
		Assert.assertTrue(list.size()>0);
	}
	
}
