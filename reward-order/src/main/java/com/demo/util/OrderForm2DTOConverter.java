package com.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.demo.dto.OrderDTO;
import com.demo.enums.ResultEnum;
import com.demo.exception.OrderException;
import com.demo.model.OrderDetail;
import com.demo.model.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderForm2DTOConverter {
	public static OrderDTO convert(OrderForm orderForm) {
		Gson gson = new Gson();
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerOpenid(orderForm.getOpenid());
		
		List<OrderDetail> orderDetailList = new ArrayList<>();
		try {
			orderDetailList = gson.fromJson(orderForm.getItems(),
					new TypeToken<List<OrderDetail>>() {}.getType()
					);
		}catch (Exception e) {
			log.error("json conversion failed",orderForm.getItems());
			throw new OrderException(ResultEnum.PARAM_ERROR);
		}
		
		orderDTO.setOrderDetailList(orderDetailList);
		return orderDTO;
		
	}
}
