package com.demo.message;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.demo.model.ProductInfoMsg;
import com.demo.model.Product_info;
import com.demo.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductInfoReceiver {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";
	
	@RabbitListener(queuesToDeclare = @Queue("productInfo"))
	public void process(String message) {
		log.info("Receive: {}", message);
		Gson gson = new Gson();
		Type listOfProductMsg = new TypeToken<ArrayList<ProductInfoMsg>>() {}.getType();
		
		List<ProductInfoMsg> productInfoMsgList = gson.fromJson(message, listOfProductMsg);
		
		for(ProductInfoMsg productInfoMsg : productInfoMsgList) {
			// store information from jms in redis
			stringRedisTemplate.opsForValue().set(
					String.format(PRODUCT_STOCK_TEMPLATE, productInfoMsg.getProductId())
					,String.valueOf(productInfoMsg.getProductStock()));
		}
	}
}
