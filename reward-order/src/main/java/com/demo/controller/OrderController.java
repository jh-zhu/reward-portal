package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.OrderDTO;
import com.demo.enums.ResultEnum;
import com.demo.exception.OrderException;
import com.demo.model.OrderForm;
import com.demo.service.OrderService;
import com.demo.util.OrderForm2DTOConverter;
import com.demo.util.ResultVOUtil;
import com.demo.vo.ResultVO;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/* Functionality: 
	 * 
	 * Validate parameter
	 * Get inventory service
	 * Calculate total amount 
	 * Deduct inventory
	 * Store order in db
	 * 
	 *
	 * */

	@PostMapping("/create")
	public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm
			,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			log.error("failed to create order",orderForm);
			throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
					bindingResult.getFieldError().getDefaultMessage());
		}
		
		OrderDTO orderDTO = OrderForm2DTOConverter.convert(orderForm);
		if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			log.error("empty cart");
			throw new OrderException(ResultEnum.CART_EMPTY);
		}
		
		OrderDTO result = orderService.create(orderDTO);
		
		Map<String,String> map  = new HashMap<>();
		map.put("orderId",result.getOrderId());
		return ResultVOUtil.success(map);
	}
	
	
}
