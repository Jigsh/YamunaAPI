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
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name = "MODEL")
public class Model implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="MODEL_ID")
	private int modelId;
	
	@Column(name="MODEL_NAME")
	private int modelName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "model_package", joinColumns = { @JoinColumn(name = "model_id") }, inverseJoinColumns = { @JoinColumn(name = "package_id") })
	List<Package> packages;
	
	
	public Model() {

	}


	public Model(int modelId, int modelName) {
		super();
		this.modelId = modelId;
		this.modelName = modelName;
	}


	public int getModelId() {
		return modelId;
	}


	public void setModelId(int modelId) {
		this.modelId = modelId;
	}


	public int getModelName() {
		return modelName;
	}


	public void setModelName(int modelName) {
		this.modelName = modelName;
	}
	@OneToMany 
	public List<Package> getPackages() {
		return packages;
	}


	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}


	@Override
	public String toString() {
		return "Model [modelId=" + modelId + ", modelName=" + modelName
				+ ", packages=" + packages + "]";
	}

	


	
}
