package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
	
}
