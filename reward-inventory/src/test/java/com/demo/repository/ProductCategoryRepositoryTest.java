package com.demo.repository;

import java.util.List;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.model.Product_category;
import com.demo.model.Product_info;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
	@Autowired
	private ProductCategoryRepository productCategoryRepo;
	
	
	@Test
	public void findByProductStatus(){
		List<Product_category> list = productCategoryRepo.findByCategoryTypeIn(Arrays.asList(11,22));
		Assert.assertTrue(list.size()>0);
	}
	
}
