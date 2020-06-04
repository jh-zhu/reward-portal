package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Product_category;
import com.demo.repository.ProductCategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public List<Product_category> findByCategoryTypeIn(List<Integer> categoryTypeList){
		return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
	}
}
