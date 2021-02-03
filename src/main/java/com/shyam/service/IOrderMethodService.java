package com.shyam.service;

import java.util.List;
import java.util.Optional;

import com.shyam.model.OrderMethod;

public interface IOrderMethodService {

	Integer saveOrderMethod(OrderMethod om);
	List<OrderMethod> getAllOrderMethod();
	public void deleteOrderMethods(Integer id);
	boolean isOrderMethodExist(Integer id);
	Optional<OrderMethod> getOneOrderMethod(Integer id);
	void updateOrderMthod(OrderMethod om);
	public boolean isOrderMethodExistByCode(String orderCode);

}
