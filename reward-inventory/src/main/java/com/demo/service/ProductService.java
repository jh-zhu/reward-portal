package com.demo.service;

import java.util.List;

import com.demo.model.Product_info;

public interface ProductService {
	/*
	 * Get all available products
	 * */
	
	List<Product_info> findUpAll();
	
}
