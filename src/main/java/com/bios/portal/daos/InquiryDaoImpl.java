package com.bios.portal.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.Inquiry;

/**
 * @author Tushar Upadhyay
 */

@Repository
public class InquiryDaoImpl implements InquiryDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean insertInquiry(Inquiry inq) throws Exception {
		entityManager.persist(inq);
		return true;
	}

	@Transactional
	public boolean updateInquiry(Inquiry inq) throws Exception {
		entityManager.merge(inq);
		return true;
	}

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Inquiry> getInquiryList(String vin) throws Exception {
		String hql = "FROM Inquiry";
		return entityManager.createQuery(hql).getResultList();
	}

	
	
}
