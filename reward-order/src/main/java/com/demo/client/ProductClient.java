package com.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.dto.CartDTO;
import com.demo.model.Product_info;

@FeignClient(name="product")
public interface ProductClient {
	@GetMapping("/msg")
	String productMsg();
	
	@PostMapping("/product/listForOrder")
	List<Product_info> listForOrder(@RequestBody List<String> productIdList);
	
	@PostMapping("/product/decreaseStock")
	void decreaseStock(@RequestBody List<CartDTO> cartDTOLlist);
}
