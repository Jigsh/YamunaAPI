package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.Maintenance;;


public interface MaintenanceService {
	boolean addLabourPosition(Maintenance lp) throws Exception;
	boolean modifyLabourPosition(Maintenance lp) throws Exception;
	List<Maintenance> fetchLabourPosition(int lpositionId) throws Exception;
	List< Maintenance > fetchLabourPositionList() throws Exception;

}
