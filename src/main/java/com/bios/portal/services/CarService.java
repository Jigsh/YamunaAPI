package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.Car;


public interface CarService {
	boolean addCar(Car car) throws Exception;
	boolean modifyCar(Car car) throws Exception;
	List< Car > fetchCarList(String vin) throws Exception;

}
