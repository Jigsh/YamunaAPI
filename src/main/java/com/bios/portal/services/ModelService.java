package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.Model;


public interface ModelService {
	boolean addModel(Model model) throws Exception;
	boolean modifyModel(Model model) throws Exception;
	List< Model > fetchModelList(String vin) throws Exception;

}
