package com.shyam.service;

import java.util.List;

import com.shyam.model.Uom;

public interface IUomService {

	Integer saveUom(Uom uom);
	List<Uom> getAllUom();
	public void deleteUom(Integer id);
	boolean isUomExist(Integer id);
}
