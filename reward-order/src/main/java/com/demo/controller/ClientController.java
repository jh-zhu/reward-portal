package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.client.ProductClient;
import com.demo.dto.CartDTO;
import com.demo.model.Product_info;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

/*
 * Develop purpose
 * 
 * */

public class ClientController {
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProductClient productClient;
	
	@GetMapping("/getProductMsg")
	public String getProductMsg() {
		RestTemplate restTemplate =  new RestTemplate();
		String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
		log.info("response = {}",response);
		return response;
	}
	
	@GetMapping("/getProductMsg1")
	public String getProductMsg1() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
		String url = String.format("http://%s:%s", serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
		RestTemplate restTemplate =  new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}
	
	
	@GetMapping("/getProductMsg2")
	public String getProductMsg2() {
		String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
		return response;
	}
	
	//Feign
	@GetMapping("/getProductMsg3")
	public String getProductMsg3() {
		String response = productClient.productMsg();
		return  response;
	}
	
	
	@GetMapping("/getProductList")
	public String getProductList() {
		List<Product_info> list = productClient.listForOrder(Arrays.asList("1"));
		log.info("response={}",list);
		return "ok";
	}
	
	@GetMapping("/productDecreaseStock")
	public void decreaseStock() {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setProductId("1");
		cartDTO.setProductQuantity(2);
		productClient.decreaseStock(Arrays.asList(cartDTO));
	}
	
	
	
}
