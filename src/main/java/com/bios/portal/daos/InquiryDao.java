package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.Inquiry;;


public interface InquiryDao {
	boolean insertInquiry(Inquiry inq) throws Exception;
	boolean updateInquiry(Inquiry inq) throws Exception;
	List< Inquiry > getInquiryList(String vin) throws Exception;
}
