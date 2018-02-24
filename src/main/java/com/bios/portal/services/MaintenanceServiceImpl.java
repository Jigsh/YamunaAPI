package com.bios.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.MaintenanceDao;
import com.bios.portal.entities.Maintenance;


@Service("LabourPositionSerive")
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService{

	@Autowired
	MaintenanceDao lpDao;
	
	public boolean addLabourPosition(Maintenance lp) throws Exception {
		return lpDao.insertLabourPosition(lp);
	}

	public boolean modifyLabourPosition(Maintenance lp) throws Exception {
		return lpDao.updateLabourPosition(lp);
	}

	@Override
	public List<Maintenance> fetchLabourPositionList() throws Exception {
		return (List < Maintenance >)lpDao.getLabourPositionList();
	}

	@Override
	public List<Maintenance> fetchLabourPosition(int lpositionId) throws Exception {
		return lpDao.getLabourPosition(lpositionId);
	}


}
