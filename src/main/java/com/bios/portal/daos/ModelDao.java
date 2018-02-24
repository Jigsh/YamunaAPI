package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.Model;


public interface ModelDao {
	boolean insertModel(Model mod) throws Exception;
	boolean updateModel(Model mod) throws Exception;
	List< Model > getModelList(String vin) throws Exception;
}
