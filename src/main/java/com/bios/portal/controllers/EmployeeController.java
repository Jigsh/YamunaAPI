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

import com.bios.portal.entities.Employee;
import com.bios.portal.services.EmployeeService;
import com.bios.portal.utils.Constants;

/**
 * @author Tushar Upadhyay
 */

@RestController
@RequestMapping("/EmployeeMasterPortal")
//@CrossOrigin(origins = "http://localhost:9090")
public class EmployeeController {

	@Autowired
	EmployeeService empSer;
	
	private static Logger log = Logger.getLogger(EmployeeController.class);
	
	//Health Check for the WebService
		@RequestMapping(value = "/healthCheck", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity< ? > checkHealth()
		{
			log.error("Service running fine!!!");
			return new ResponseEntity< String >("{\"success\":\"Service Available\"}",HttpStatus.OK);
		}
		
		//User Service APIs (Register, Login, Logout and Update Profile)
		@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody ResponseEntity < ? > userRegistration(@RequestBody Employee emp) {
	        try {
	            if (empSer.addEmployee(emp)) {
	                log.info("User registered Successfully " + emp.getFirstName() + " " + emp.getLastName());
	                return new ResponseEntity < String > (Constants.SUCCESS_STATUS + Constants.INSERTED_SUCCESS, HttpStatus.OK);
	            } else {
	                log.error("User registration Failed " + emp.getFirstName() + " " + emp.getLastName());
	                return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.INSERTED_FAILURE, HttpStatus.BAD_REQUEST);
	            }
	        } catch (Exception e) {
	            log.error("User registration Failed " + e.getMessage());
	            return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.INSERTED_FAILURE, HttpStatus.NOT_IMPLEMENTED);
	        }
	    }

	    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody ResponseEntity < ? > userLogin(@RequestBody Employee emp) {
	        try {
	            if (empSer.findEmployee(emp)) {
	                log.info("User Logged In Successfully " + emp.getUserName());
	                return new ResponseEntity < String > (Constants.SUCCESS_STATUS + Constants.LOGIN_SUCCESS, HttpStatus.OK);
	            } else {
	                log.error("User Log In Failed" + emp.getUserName());
	                return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.LOGIN_FAILURE_NO_USER, HttpStatus.OK);
	            }
	        } catch (Exception e) {
	            log.error("User Log In Failed" + e.getMessage());
	            return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.LOGIN_FAILURE_NO_USER, HttpStatus.OK);
	        }
	    }

	    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody ResponseEntity < ? > userLogout() {
	        log.info("User Logged Out Successfully");
	        return new ResponseEntity < String > (Constants.SUCCESS_STATUS + Constants.LOGOUT_FAIL, HttpStatus.OK);
	    }
	    
	    @RequestMapping(value = "/getProfile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity< ? > getUserProfile(@RequestParam("userName") String userName)
		{
			try {
				Employee emp = empSer.fetchEmployee(userName);
				if(emp != null){
					return new ResponseEntity< Employee >(emp,HttpStatus.OK);
				} else {
					log.error("User Profile Delivery Failed");
					return new ResponseEntity< String >(Constants.FAILURE_STATUS + Constants.GET_FAILURE, HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				log.error("User Profile Delivery Failed "+e.getMessage());
				return new ResponseEntity< String >(Constants.FAILURE_STATUS + Constants.GET_FAILURE, HttpStatus.NOT_IMPLEMENTED);
			}
		}
	    
	    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody ResponseEntity < ? > profileUpdate(@RequestBody Employee emp) {
	        try {
	            if (empSer.modifyEmployee(emp)) {
	                log.info("User Profile Updated Successfully " + emp.getUserName());
	                return new ResponseEntity < String > (Constants.SUCCESS_STATUS + Constants.UPDATED_SUCCESS, HttpStatus.OK);
	            } else {
	                log.error("User Profile Update Failed " + emp.getUserName());
	                return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.UPDATED_FAILURE, HttpStatus.BAD_REQUEST);
	            }
	        } catch (Exception e) {
	            log.error("User Profile Update Failed " + e.getMessage());
	            return new ResponseEntity < String > (Constants.FAILURE_STATUS + Constants.UPDATED_FAILURE, HttpStatus.NOT_IMPLEMENTED);
	        }
	    }
	    @RequestMapping(value = "/deactivate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity< ? > deactivateEmployee(@RequestParam("empId") int empId)
		{
			try {			
				if(empSer.removeEmployee(empId)){
					log.info("User deleted successfully");
					return new ResponseEntity< String >(Constants.SUCCESS_STATUS + Constants.DELETED_SUCCESS, HttpStatus.OK);
				} else {
					log.error("User deleting  Failed");
					return new ResponseEntity< String >(Constants.FAILURE_STATUS + Constants.DELETED_FAILURE, HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				log.error("User deleting Failed "+ e.getMessage());
				return new ResponseEntity< String >(Constants.FAILURE_STATUS + Constants.DELETED_FAILURE, HttpStatus.NOT_IMPLEMENTED);
			}
		}
	    
	    @RequestMapping(value = "/getEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity< ? > fetchEmployee(@RequestParam("userName") String userName)
		{
			List<Employee> resultList = null;
			try {
				resultList = empSer.fetchEmployeeList();
				if(resultList != null){
					return new ResponseEntity< List< Employee > >(resultList, HttpStatus.OK);
				} else {
					log.error("Projects Delivery Failed");
					return new ResponseEntity< List< Employee > >(resultList, HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				log.error("Projects Delivery Failed "+ e.getMessage());
				return new ResponseEntity< List< Employee > >(resultList, HttpStatus.NOT_IMPLEMENTED);
			}
		}
}
