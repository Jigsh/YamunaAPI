package com.bios.portal.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.Maintenance;



@Repository
public class MaintenanceDaoImpl implements MaintenanceDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean insertLabourPosition(Maintenance inq) throws Exception {
		entityManager.persist(inq);
		return true;
	}

	@Transactional
	public boolean updateLabourPosition(Maintenance inq) throws Exception {
		entityManager.merge(inq);
		return true;
	}

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Maintenance> getLabourPosition(int lposition_id) throws Exception {
		String hql = "FROM Maintenance where lposition_id = ?";
		return entityManager.createQuery(hql).getResultList();
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Maintenance> getLabourPositionList() throws Exception {
		String hql = "FROM Maintenance";
		return entityManager.createQuery(hql).getResultList();
	}

	
	
}
