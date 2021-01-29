package com.shyam.service;

import java.util.List;
import java.util.Optional;

import com.shyam.model.ShipmentType;

public interface IShipmentTypeService 
{
	Integer saveShipmentType(ShipmentType st);
	List<ShipmentType> getAllShipmentType();
	public void deleteShipmentTypes(Integer id);
	boolean isShipmentTypeExist(Integer id);
	Optional<ShipmentType> getOneShipmentType(Integer id);
	void updateShipmentType(ShipmentType st);
}
