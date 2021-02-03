package com.shyam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shyam.model.OrderMethod;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer> 
{
	@Query("SELECT COUNT(om.orderCode) FROM OrderMethod om WHERE om.orderCode=:orderCode")
	public Integer getOrderMethodCountByCode(String orderCode);
}
