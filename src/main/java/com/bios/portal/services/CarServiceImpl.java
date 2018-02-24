package com.bios.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.CarDao;
import com.bios.portal.entities.Car;



@Service("CarSerive")
@Transactional
public class CarServiceImpl implements CarService{

	@Autowired
	CarDao carDao;
	
	public boolean addCar(Car car) throws Exception {
		return carDao.insertCar(car);
	}

	public boolean modifyCar(Car car) throws Exception {
		return carDao.updateCar(car);
	}

	@Override
	public List<Car> fetchCarList(String vin) throws Exception {
		return (List < Car >)carDao.getCarList(vin);
	}

}
