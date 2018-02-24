package com.bios.portal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME",length=50)
	private String userName;
	
	@Column(name="IS_ACTIVE",length=1)
	private String isActive;
	
	@Column(name="LOGIN_NAME",length=50)
	private String loginName;
	
	@Column(name="PWDHSH",length=100)
	private String password;
	
	@Column(name="USER_ROLE",length=100)
	private String userRole;
	
	
	public User() {

	}


	public User(int userId, String userName, String isActive, String loginName,
			String password, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.isActive = isActive;
		this.loginName = loginName;
		this.password = password;
		this.userRole = userRole;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", isActive=" + isActive + ", loginName=" + loginName
				+ ", password=" + password + ", userRole=" + userRole + "]";
	}

	
	
}
