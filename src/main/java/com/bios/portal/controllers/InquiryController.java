package com.bios.portal.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bios.portal.entities.Inquiry;
import com.bios.portal.services.InquiryService;
import com.bios.portal.utils.Constants;


@RestController
@RequestMapping("/BIOS")
//@CrossOrigin(origins = "http://localhost:9090")
public class InquiryController {

	@Autowired
	InquiryService inqSer;
	
	private static Logger log = Logger.getLogger(InquiryController.class);
	
	//Health Check for the WebService
		@RequestMapping(value = "/healthCheck", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity< ? > checkHealth()
		{
			log.error("Service running fine!!!");
			return new ResponseEntity< String >("{\"success\":\"Service Available\"}",HttpStatus.OK);
		}
		
		
	    // This is called when Service Advisor types VIN on the screen and wants to fetch all the old Inquiries for it.
		// The method returns list of all the old Inquiries.
	    @RequestMapping(value = "/inquiries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity< ? > getInquiries(@RequestParam("vin") String vin)
		{
			try {
				List<Inquiry> inqList = inqSer.fetchInquiryList(vin);
				if(inqList != null){
					return new ResponseEntity< List<Inquiry> >(inqList, HttpStatus.OK);
				} else {
					log.error("Could not fetch list of inquiries");
					return new ResponseEntity< String >(Constants.FAILURE_STATUS + Constants.GET_FAILURE, HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				log.error("Could not fetch list of inquiries " + e.getMessage());
				return new ResponseEntity< String >(Constants.FAILURE_STATUS + Constants.GET_FAILURE, HttpStatus.NOT_IMPLEMENTED);
			}
		}
	    
	    // This is called when Service Advisor saves an existing Inquiry after any update to the Inquiry
	    @RequestMapping(value = "/updateInquiry", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody ResponseEntity < ? > modifyInquiry(@RequestBody Inquiry inq) {
	        try {
	            if (inqSer.modifyInquiry(inq)) {
	                log.info("Inquiry Updated Successfully " + inq.getVin() + " " + inq.getInquiryId());
	                return new ResponseEntity < String > (Constants.SUCCESS_STATUS + Constants.UPDATED_SUCCESS, HttpStatus.OK);
	            } else {
	                log.error("Inquiry Update Failed " +  inq.getVin() + " " + inq.getInquiryId());
	                return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.UPDATED_FAILURE, HttpStatus.BAD_REQUEST);
	            }
	        } catch (Exception e) {
	            log.error("Inquiry Update Failed " +  inq.getVin() + " " + inq.getInquiryId());
	            return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.UPDATED_FAILURE, HttpStatus.NOT_IMPLEMENTED);
	        }
	    }
	    
	    // This is called when Service Advisor saves a new Inquiry 
	    @RequestMapping(value = "/createInquiry", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody ResponseEntity < ? > saveInquiry(@RequestBody Inquiry inq) {
	        try {
	            if (inqSer.addInquiry(inq)) {
	                log.info("Inquiry added Successfully " + inq.getVin() );
	                return new ResponseEntity < String > (Constants.SUCCESS_STATUS + Constants.INSERTED_SUCCESS, HttpStatus.OK);
	            } else {
	                log.error("Inquiry adding Failed " + inq.getVin());
	                return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.INSERTED_FAILURE, HttpStatus.BAD_REQUEST);
	            }
	        } catch (Exception e) {
	            log.error("Inquiry adding Failed " + inq.getVin());
	            return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.INSERTED_FAILURE, HttpStatus.NOT_IMPLEMENTED);
	        }
	    }
	   
}
