package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.enums.ProductStatusEnum;
import com.demo.model.Product_info;
import com.demo.repository.ProductInfoRepository;


@Service
public class ProductSrviceImpl implements ProductService{
	
	@Autowired
	ProductInfoRepository productInfoRepository;
	
	@Override
	public List<Product_info> findUpAll(){
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}
}
