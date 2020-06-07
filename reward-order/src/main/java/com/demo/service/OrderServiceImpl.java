package com.demo.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.client.ProductClient;
import com.demo.dto.CartDTO;
import com.demo.dto.OrderDTO;
import com.demo.enums.OrderStatus;
import com.demo.model.OrderDetail;
import com.demo.model.OrderMaster;
import com.demo.model.Product_info;
import com.demo.repository.OrderDetailRepository;
import com.demo.repository.OrderMasterRepository;
import com.demo.util.KeyUtil;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	ProductClient productClient;
	
	
	@Override
	public OrderDTO create(OrderDTO orderDTO) {
		String orderId = KeyUtil.genUniqueKey();
		// query inventory service 
		List<String> productIdList = orderDTO.getOrderDetailList().stream()
				.map(OrderDetail::getProductId)
				.collect(Collectors.toList());
		List<Product_info> productInfoList = productClient.listForOrder(productIdList);
		
		// calculate total amount 
		BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
		for(OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
			for(Product_info productInfo: productInfoList) {
				if(productInfo.getProductId().equals(orderDetail.getProductId())) {
					orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
							.add(orderAmount);
					BeanUtils.copyProperties(productInfo, orderDetail);
					orderDetail.setOrderId(orderId);
					orderDetail.setDetailId(KeyUtil.genUniqueKey());
					orderDetailRepository.save(orderDetail);
				}
			}
		}
		
		
		// decrease inventory
		List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
				.map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
				.collect(Collectors.toList());
		productClient.decreaseStock(cartDTOList);
		
		
		
		// store order in master table
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(orderId);
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(orderAmount);
		orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
		orderMasterRepository.save(orderMaster);
		
	
		return orderDTO;
	}
}
