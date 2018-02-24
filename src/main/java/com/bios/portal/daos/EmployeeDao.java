package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.Employee;


public interface EmployeeDao {
	boolean insertEmployee(Employee emp) throws Exception;
	boolean updatetEmployee(Employee emp) throws Exception;
	boolean deleteEmployee(int empId) throws Exception;
	List< Employee > getEmployee(String userName) throws Exception;
	List< Employee > getEmployeeList() throws Exception;
}
