package com.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.model.Product_info;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	
	@Test
	public void findByProductStatus(){
		List<Product_info> list = productInfoRepository.findByProductStatus(0);
		Assert.assertTrue(list.size()>0);
	}
	
	@Test
	public void findByProductIdIn() {
		List<Product_info> list = productInfoRepository.findByProductIdIn(Arrays.asList("1","2","3"));
		assertTrue(list.size()>0);
	}
}
