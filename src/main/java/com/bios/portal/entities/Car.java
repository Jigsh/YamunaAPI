package com.bios.portal.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bios.portal.entities.Maintenance;
import com.bios.portal.entities.Spare;


@Entity
@Table (name = "CAR")
public class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="CAR_ID")
	private int carId;
	
	@Column(name="VIN",length=17)
	private String vin;
	
	@Column(name="MODEL_ID")
	private int modelId;
	
	
	public Car() {

	}


	public Car(int carId, String vin, int modelId) {
		super();
		this.carId = carId;
		this.vin = vin;
		this.modelId = modelId;
	}


	public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public int getModelId() {
		return modelId;
	}


	public void setModelId(int modelId) {
		this.modelId = modelId;
	}


	@Override
	public String toString() {
		return "Car [carId=" + carId + ", vin=" + vin + ", modelId=" + modelId
				+ "]";
	}

	
	
	
}
