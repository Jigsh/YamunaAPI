package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.Maintenance;


public interface MaintenanceDao {
	boolean insertLabourPosition(Maintenance lp) throws Exception;
	boolean updateLabourPosition(Maintenance lp) throws Exception;
	List< Maintenance > getLabourPosition(int lpositionId) throws Exception;
	List< Maintenance > getLabourPositionList() throws Exception;
}


