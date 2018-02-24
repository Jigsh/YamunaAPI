package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.Spare;


public interface SpareService {
	boolean addSpare(Spare spare) throws Exception;
	boolean modifySpare(Spare spare) throws Exception;
	List< Spare > fetchSpareList(String spare) throws Exception;

}
