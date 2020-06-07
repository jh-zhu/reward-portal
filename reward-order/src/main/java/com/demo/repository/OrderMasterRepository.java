package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{
	
}
