package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.AdditionalItem;;

public interface AdditionalItemDao {
	boolean insertAdditionalItem(AdditionalItem item) throws Exception;
	boolean updateAdditionalItem(AdditionalItem item) throws Exception;
	//boolean deleteAdditionalItem(int empId) throws Exception;
	//List< AdditionalItem > getAdditionalItem(int inqId) throws Exception;
	List< AdditionalItem > getAdditionalItemList(int inqId) throws Exception;
}
