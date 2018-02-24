package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.Spare;;


public interface SpareDao {
	boolean insertSpare(Spare inq) throws Exception;
	boolean updateSpare(Spare inq) throws Exception;
	List< Spare > getSpareList(String vin) throws Exception;
}
