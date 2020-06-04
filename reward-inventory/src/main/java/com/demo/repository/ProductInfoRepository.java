package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Product_info;

public interface ProductInfoRepository extends JpaRepository<Product_info,String> {
	List<Product_info> findByProductStatus(Integer productStatus);
}
