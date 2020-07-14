package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.enums.ProductStatusEnum;
import com.demo.enums.ResultEnum;
import com.demo.exception.ProductException;
import com.demo.model.CartDTO;
import com.demo.model.ProductInfoMsg;
import com.demo.model.Product_info;
import com.demo.repository.ProductInfoRepository;
import com.demo.util.JsonUtil;

@Service
public class ProductSrviceImpl implements ProductService{
	
	@Autowired
	ProductInfoRepository productInfoRepository;
	
	@Autowired
	AmqpTemplate amqpTemplate;
	
	@Override
	public List<Product_info> findUpAll(){
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}
	
	@Override
	public  List<Product_info> findList(List<String> productIdList){
		return productInfoRepository.findByProductIdIn(productIdList);
	}
	
	@Override
	public void decreaseStock(List<CartDTO> cartDTOList) {
		List<ProductInfoMsg> productInfoMsgList = decreaseStockList(cartDTOList);
		
		//send mq message
		amqpTemplate.convertAndSend("productInfo",JsonUtil.toJson(productInfoMsgList));
			
	}
	
	@Transactional	
	public List<ProductInfoMsg> decreaseStockList(List<CartDTO> cartDTOList) {
		List<ProductInfoMsg> productInfoMsgList = new ArrayList<>();
			
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
				
				
			ProductInfoMsg productInfoMsg = new ProductInfoMsg();
			BeanUtils.copyProperties(productInfo, productInfoMsg);
			productInfoMsgList.add(productInfoMsg);
				
		}
		return productInfoMsgList;
		
	}
	
}
