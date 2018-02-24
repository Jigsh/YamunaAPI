package com.bios.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.AdditionalItemDao;
import com.bios.portal.entities.AdditionalItem;


@Service("AdditionalItemSerive")
@Transactional
public class AdditionalItemServiceImpl implements AdditionalItemService{

	@Autowired
	AdditionalItemDao AdditionalItemDao;
	
	public boolean addAdditionalItem(AdditionalItem additionalItem) throws Exception {
		return AdditionalItemDao.insertAdditionalItem(additionalItem);
	}

	public boolean modifyAdditionalItem(AdditionalItem additionalItem) throws Exception {
		return AdditionalItemDao.updateAdditionalItem(additionalItem);
	}

	@Override
	public List<AdditionalItem> fetchAdditionalItemList(int inqId) throws Exception {
		return (List < AdditionalItem >)AdditionalItemDao.getAdditionalItemList(inqId);
	}

}
