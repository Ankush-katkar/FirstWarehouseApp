package com.shyam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shyam.model.Uom;
import com.shyam.repo.UomRepository;
import com.shyam.service.IUomService;

@Service
public class UomServiceImpl  implements IUomService	{

	@Autowired
	private UomRepository repo;
	@Override
	public Integer saveUom(Uom uom) {
		// TODO Auto-generated method stub
		uom=repo.save(uom);
		Integer id=uom.getId();
		return id;
	}
	@Override
	public List<Uom> getAllUom() {
		// TODO Auto-generated method stub
		List<Uom> list=repo.findAll();
		return list;
	}
	@Override
	public void deleteUom(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	@Override
	public boolean isUomExist(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	
}
