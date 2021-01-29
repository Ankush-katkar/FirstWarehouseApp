package com.shyam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shyam.model.OrderMethod;
import com.shyam.repo.OrderMethodRepository;
import com.shyam.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService
{
	@Autowired
	private OrderMethodRepository repo;

	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		om=repo.save(om);
		Integer id=om.getId();
		return id;
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		// TODO Auto-generated method stub
		List<OrderMethod> list=repo.findAll();
		return list;
	}

	@Override
	public void deleteOrderMethods(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public boolean isOrderMethodExist(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	@Override
	public Optional<OrderMethod> getOneOrderMethod(Integer id) {
		// TODO Auto-generated method stub
		Optional<OrderMethod> opt=repo.findById(id);
		return opt;
	}

	@Override
	public void updateOrderMthod(OrderMethod om) {
		// TODO Auto-generated method stub
		repo.save(om);
	}
	

}
