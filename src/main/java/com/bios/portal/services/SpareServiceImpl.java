package com.bios.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.SpareDao;
import com.bios.portal.entities.Spare;


@Service("SpareService")
@Transactional
public class SpareServiceImpl implements SpareService{

	@Autowired
	SpareDao spareDao;
	
	public boolean addSpare(Spare inq) throws Exception {
		return spareDao.insertSpare(inq);
	}

	public boolean modifySpare(Spare inq) throws Exception {
		return spareDao.updateSpare(inq);
	}

	@Override
	public List<Spare> fetchSpareList(String vin) throws Exception {
		return (List < Spare >)spareDao.getSpareList(vin);
	}

}
