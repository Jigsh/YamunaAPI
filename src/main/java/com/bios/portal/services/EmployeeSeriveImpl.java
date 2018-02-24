package com.bios.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.EmployeeDao;
import com.bios.portal.entities.Employee;


@Service("EmployeeSerive")
@Transactional
public class EmployeeSeriveImpl implements EmployeeService{

	@Autowired
	EmployeeDao empDao;
	
	public boolean addEmployee(Employee emp) throws Exception {
		return empDao.insertEmployee(emp);
	}

	public boolean modifyEmployee(Employee emp) throws Exception {
		return empDao.updatetEmployee(emp);
	}

	public boolean removeEmployee(int empId) throws Exception {
		return empDao.deleteEmployee(empId);
	}

	public boolean findEmployee(Employee emp) throws Exception {
		List < Employee > resEmp = empDao.getEmployee(emp.getUserName());
        if (resEmp != null) {
            for (Employee emp1: resEmp) {
                return emp1.getPassword().equals(emp.getPassword()) ? true : false;
            }
        }
        return false;
	}

	public Employee fetchEmployee(String userName) throws Exception {
		List < Employee > resEmp = empDao.getEmployee(userName);
        if (resEmp != null) {
            for (Employee emp1: resEmp) {
                return emp1;
            }
        }
        return null;
	}

	public List<Employee> fetchEmployeeList() throws Exception {
		return (List < Employee >)empDao.getEmployeeList();
	}

}
