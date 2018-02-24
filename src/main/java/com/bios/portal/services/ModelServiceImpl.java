package com.bios.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.ModelDao;
import com.bios.portal.entities.Model;


@Service("ModelSerive")
@Transactional
public class ModelServiceImpl implements ModelService{

	@Autowired
	ModelDao modelDao;
	
	public boolean addModel(Model model) throws Exception {
		return modelDao.insertModel(model);
	}

	public boolean modifyModel(Model model) throws Exception {
		return modelDao.updateModel(model);
	}

	@Override
	public List<Model> fetchModelList(String vin) throws Exception {
		return (List < Model >)modelDao.getModelList(vin);
	}

}
