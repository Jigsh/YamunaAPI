package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.Employee;

public interface EmployeeService {
	boolean addEmployee(Employee emp) throws Exception;
	boolean modifyEmployee(Employee emp) throws Exception;
	boolean removeEmployee(int empId) throws Exception;
	boolean findEmployee(Employee emp) throws Exception;
	Employee fetchEmployee(String userName) throws Exception;
	List< Employee > fetchEmployeeList() throws Exception;
}
