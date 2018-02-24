package com.bios.portal.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean insertEmployee(Employee emp) throws Exception {
		entityManager.persist(emp);
		return true;
	}

	@Transactional
	public boolean updatetEmployee(Employee emp) throws Exception {
		entityManager.merge(emp);
		return true;
	}

	@Transactional
	public boolean deleteEmployee(int empId) throws Exception {
		String hql = "DELETE FROM Employee E WHERE E.empId = ? ";
		return entityManager.createQuery(hql).setParameter(1, empId).executeUpdate() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Employee> getEmployee(String userName) throws Exception {
		String hql = "FROM Employee E WHERE E.userName = ? ";
		return entityManager.createQuery(hql).setParameter(1, userName).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Employee> getEmployeeList() throws Exception {
		String hql = "FROM Employee";
		return entityManager.createQuery(hql).getResultList();
	}

	
	
}
