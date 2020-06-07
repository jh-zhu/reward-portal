package com.demo.repository;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.RewardOrderApplicationTests;
import com.demo.enums.OrderStatus;
import com.demo.model.OrderDetail;
import com.demo.model.OrderMaster;

@Component
public class OrderDetailRepositoryTest extends RewardOrderApplicationTests{
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	@Autowired
	OrderMasterRepository orderMasterRepository;
	
	@Test
	public void testSave1(){
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("123");
		orderMaster.setBuyerName("John");
		orderMaster.setBuyerOpenid("3020");
		orderMaster.setOrderAmount(new BigDecimal(100.55));
		orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
		
		OrderMaster result = orderMasterRepository.save(orderMaster);
		Assert.assertTrue(result!=null);
	}
	
	@Test
	public void testSave() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDetailId("1234");
		orderDetail.setOrderId("123");
		orderDetail.setProductId("9958");
		orderDetail.setProductName("burger");
		orderDetail.setProductPrice(new BigDecimal(5.5));
		orderDetail.setProductQuantity(5);
		
		OrderDetail result = orderDetailRepository.save(orderDetail);
		Assert.assertTrue(result!=null);
		
	}
	
}
