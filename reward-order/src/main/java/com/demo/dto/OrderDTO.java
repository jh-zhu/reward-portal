package com.demo.dto;

import java.math.BigDecimal;
import java.util.List;

import com.demo.model.OrderDetail;

import lombok.Data;


@Data
public class OrderDTO {
	private String orderId;
	
	private String buyerName;
	private String buyerOpenid;
	private BigDecimal orderAmount;
	private Integer orderStatus;
	
	private List<OrderDetail> orderDetailList;
}
