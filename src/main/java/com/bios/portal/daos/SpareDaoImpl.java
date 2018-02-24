package com.bios.portal.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.Spare;


@Repository
public class SpareDaoImpl implements SpareDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean insertSpare(Spare spare) throws Exception {
		entityManager.persist(spare);
		return true;
	}

	@Transactional
	public boolean updateSpare(Spare spare) throws Exception {
		entityManager.merge(spare);
		return true;
	}

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Spare> getSpareList(String vin) throws Exception {
		String hql = "FROM Spare";
		return entityManager.createQuery(hql).getResultList();
	}

	
	
}
