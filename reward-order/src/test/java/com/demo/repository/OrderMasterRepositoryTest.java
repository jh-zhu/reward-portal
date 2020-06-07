package com.demo.repository;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.RewardOrderApplicationTests;
import com.demo.enums.OrderStatus;
import com.demo.model.OrderMaster;

import junit.framework.Assert;

@Component
public class OrderMasterRepositoryTest extends RewardOrderApplicationTests{
	@Autowired
	OrderMasterRepository orderMasterRepository;
	
	
	@Test
	public void testSave(){
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("123");
		orderMaster.setBuyerName("John");
		orderMaster.setBuyerOpenid("3020");
		orderMaster.setOrderAmount(new BigDecimal(100.55));
		orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
		
		OrderMaster result = orderMasterRepository.save(orderMaster);
		Assert.assertTrue(result!=null);
	}
}
