package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.Inquiry;


public interface InquiryService {
	boolean addInquiry(Inquiry emp) throws Exception;
	boolean modifyInquiry(Inquiry emp) throws Exception;
	List< Inquiry > fetchInquiryList(String vin) throws Exception;

}
