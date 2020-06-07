package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.enums.ProductStatusEnum;
import com.demo.enums.ResultEnum;
import com.demo.exception.ProductException;
import com.demo.model.CartDTO;
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
	
	@Override
	public  List<Product_info> findList(List<String> productIdList){
		return productInfoRepository.findByProductIdIn(productIdList);
	}
	
	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		for(CartDTO cartDTO: cartDTOList) {
			Optional<Product_info> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
			
			// if merchandise exists
			if(!productInfoOptional.isPresent()) {
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXITS);
			}
			
			// check inventory stock
			Product_info productInfo = productInfoOptional.get();
			Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
			if(result < 0) {
				throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			
			productInfo.setProductStock(result);
			productInfoRepository.save(productInfo);
		}
		
		
	}
	
}
