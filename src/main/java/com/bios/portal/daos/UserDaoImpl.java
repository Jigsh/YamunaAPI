package com.bios.portal.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.User;


@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean insertUser(User user) throws Exception {
		entityManager.persist(user);
		return true;
	}

	@Transactional
	public boolean updateUser(User user) throws Exception {
		entityManager.merge(user);
		return true;
	}

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<User> getUserList(String userId) throws Exception {
		String hql = "FROM User";
		return entityManager.createQuery(hql).getResultList();
	}

	
	
}
