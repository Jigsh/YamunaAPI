package com.bios.portal.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.Model;

@Repository
public class ModelDaoImpl implements ModelDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean insertModel(Model mod) throws Exception {
		entityManager.persist(mod);
		return true;
	}

	@Transactional
	public boolean updateModel(Model mod) throws Exception {
		entityManager.merge(mod);
		return true;
	}

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Model> getModelList(String vin) throws Exception {
		String hql = "FROM Model";
		return entityManager.createQuery(hql).getResultList();
	}

	
	
}
