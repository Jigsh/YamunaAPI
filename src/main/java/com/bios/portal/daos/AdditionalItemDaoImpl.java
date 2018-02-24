package com.bios.portal.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.AdditionalItem;


@Repository
public class AdditionalItemDaoImpl implements AdditionalItemDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean insertAdditionalItem(AdditionalItem inq) throws Exception {
		entityManager.persist(inq);
		return true;
	}

	@Transactional
	public boolean updateAdditionalItem(AdditionalItem inq) throws Exception {
		entityManager.merge(inq);
		return true;
	}

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<AdditionalItem> getAdditionalItemList(int inqId) throws Exception {
		String hql = "FROM AdditionalItem";
		return entityManager.createQuery(hql).getResultList();
	}

	
	
}
