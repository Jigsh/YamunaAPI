package com.bios.portal.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.Car;


@Repository
public class CarDaoImpl implements CarDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean insertCar(Car car) throws Exception {
		entityManager.persist(car);
		return true;
	}

	@Transactional
	public boolean updateCar(Car car) throws Exception {
		entityManager.merge(car);
		return true;
	}

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Car> getCarList(String vin) throws Exception {
		String hql = "FROM Car";
		return entityManager.createQuery(hql).getResultList();
	}

	
	
}
