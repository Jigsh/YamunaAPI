package com.bios.portal.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bios.portal.entities.Maintenance;
import com.bios.portal.entities.Spare;

@Entity
@Table (name = "PACKAGE")
public class Package implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="PACKAGE_ID")
	private int packageId;
	
	@Column(name="PACKAGE_NAME",length=100)
	private String packageName;
	
	@Column(name="PRICE")
	private int price;
	
	@Column(name="DESCRIPTION",length=200)
	private String description;
	
	@Column(name="IS_ACTIVE",length=1)
	private String isActive;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "package_spare", joinColumns = { @JoinColumn(name = "package_id") }, inverseJoinColumns = { @JoinColumn(name = "spare_id") })
	List<Spare> spareParts;
	Integer labourPositions;
	
	
	public Package() {

	}

	public Package(int packageId, String packageName, int price,
			String description, String isActive, List<Spare> spareParts,
			Integer labourPositions) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.price = price;
		this.description = description;
		this.isActive = isActive;
		this.spareParts = spareParts;
		this.labourPositions = labourPositions;
	}




	public int getPackageId() {
		return packageId;
	}


	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public List<Spare> getSpareParts() {
		return spareParts;
	}

	public void setSpareParts(List<Spare> spareParts) {
		this.spareParts = spareParts;
	}

	public Integer getLabourPositions() {
		return labourPositions;
	}

	public void setLabourPositions(Integer labourPositions) {
		this.labourPositions = labourPositions;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName="
				+ packageName + ", price=" + price + ", description="
				+ description + ", isActive=" + isActive + ", spareParts="
				+ spareParts + ", labourPositions=" + labourPositions + "]";
	}

	

	
	
}
