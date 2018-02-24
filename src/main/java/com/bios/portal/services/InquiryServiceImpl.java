package com.bios.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.InquiryDao;
import com.bios.portal.entities.Inquiry;



@Service("InquirySerive")
@Transactional
public class InquiryServiceImpl implements InquiryService{

	@Autowired
	InquiryDao inqDao;
	
	public boolean addInquiry(Inquiry inq) throws Exception {
		return inqDao.insertInquiry(inq);
	}

	public boolean modifyInquiry(Inquiry inq) throws Exception {
		return inqDao.updateInquiry(inq);
	}

	@Override
	public List<Inquiry> fetchInquiryList(String vin) throws Exception {
		return (List < Inquiry >)inqDao.getInquiryList(vin);
	}

}
