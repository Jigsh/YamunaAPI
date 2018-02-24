
package com.bios.portal.controllers;


import java.util.List;







import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bios.portal.daos.PackageDao;
import com.bios.portal.daos.PackageDaoImpl;
import com.bios.portal.entities.Inquiry;
import com.bios.portal.entities.Package;
import com.bios.portal.services.InquiryService;
import com.bios.portal.services.PackageService;
import com.bios.portal.utils.Constants;

@RestController
@RequestMapping("/BIOS")
public class PackageController {
	@Autowired
	PackageService packageSer;
	
	private static Logger log = Logger.getLogger(InquiryController.class);
	

    @RequestMapping("/packagess")
    public List<Package> greeting(@RequestParam(value="vin", defaultValue="002")  String vin) {
    	PackageDaoImpl packageDao = new PackageDaoImpl();
    	return packageDao.getPackagesByVIN(vin);
        
    }
    
    @RequestMapping(value = "/packages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity< ? > getPackages(@RequestParam("vin") String vin)
	{
		try {
			List<Package> pkgList = packageSer.fetchPackageList(vin);
			if(pkgList != null){
				return new ResponseEntity< List<Package> >(pkgList, HttpStatus.OK);
			} else {
				log.error("Could not fetch list of packages");
				return new ResponseEntity< String >(Constants.FAILURE_STATUS + Constants.GET_FAILURE, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Could not fetch list of packages " + e.getMessage());
			return new ResponseEntity< String >(Constants.FAILURE_STATUS + Constants.GET_FAILURE, HttpStatus.NOT_IMPLEMENTED);
		}
	}
   
}