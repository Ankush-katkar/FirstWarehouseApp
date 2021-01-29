
package com.shyam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shyam.model.ShipmentType;
import com.shyam.repo.ShipmentTypeRepo;
import com.shyam.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService
{
	@Autowired
	private ShipmentTypeRepo repo; //HAS-A

	@Override
	public Integer saveShipmentType(ShipmentType st) {
		// TODO Auto-generated method stub
		st=repo.save(st);
		Integer id=st.getId();
		return id;
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {
		// TODO Auto-generated method stub
		List<ShipmentType> list=repo.findAll();
		return list;
	}
	
	@Override
	public void deleteShipmentTypes(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public boolean isShipmentTypeExist(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}
	@Override
	public Optional<ShipmentType> getOneShipmentType(Integer id) {
		// TODO Auto-generated method stub
		Optional<ShipmentType> opt=repo.findById(id);
		return opt;
	}
	@Override
	public void updateShipmentType(ShipmentType st) {
		// TODO Auto-generated method stub
		repo.save(st);//Update SQL.......
	}
}
