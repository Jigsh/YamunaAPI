package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.AdditionalItem;


public interface AdditionalItemService {
	boolean addAdditionalItem(AdditionalItem additionalItem) throws Exception;
	boolean modifyAdditionalItem(AdditionalItem additionalItem) throws Exception;
	List< AdditionalItem > fetchAdditionalItemList(int inqId) throws Exception;

}
