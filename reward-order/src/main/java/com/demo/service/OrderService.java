package com.demo.service;

import com.demo.dto.OrderDTO;

public interface OrderService {
	
	/*
	 * create order
	 * @param orderDTO
	 * @return orderDTO
	 * 
	 * */
	OrderDTO create(OrderDTO orderDTO);
	
}
