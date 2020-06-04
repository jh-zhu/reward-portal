package com.demo.service;

import java.util.List;



import com.demo.model.Product_category;



public interface CategoryService {
	
	List<Product_category> findByCategoryTypeIn(List<Integer> categoryTypeList);
	
	
}
