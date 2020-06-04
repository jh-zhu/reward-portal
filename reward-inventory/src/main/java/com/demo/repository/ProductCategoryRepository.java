package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Product_category;
import com.demo.model.Product_info;

public interface ProductCategoryRepository extends JpaRepository<Product_category,String>{
	List<Product_category> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
