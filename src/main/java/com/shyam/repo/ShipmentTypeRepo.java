package com.shyam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.model.ShipmentType;

public interface ShipmentTypeRepo extends JpaRepository<ShipmentType, Integer> 
{

}
