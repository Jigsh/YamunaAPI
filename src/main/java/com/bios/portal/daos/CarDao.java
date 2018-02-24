package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.Car;


public interface CarDao {
	boolean insertCar(Car car) throws Exception;
	boolean updateCar(Car car) throws Exception;
	List< Car > getCarList(String vin) throws Exception;
}
