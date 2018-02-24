package com.bios.portal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "EMP_TABLE")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="EMP_ID")
	private int empId;
	
	@Column(name="USER_NAME",length=50)
	private String userName;
	
	@Column(name="FIRST_NAME",length=50)
	private String firstName;
	
	@Column(name="LAST_NAME",length=50)
	private String lastName;
	
	@Column(name="EMAIL_ID",length=50)
	private String emailId;
	
	@Column(name="MOBILE",length=15)
	private String mobileNumber;
	
	@Column(name="BOD",length=12)
	private String birthDate;
	
	@Column(name="JOD",length=12)
	private String joiningDate;
	
	@Column(name="CTC",length=12)
	private int ctc;
	
	@Column(name="PROJECT",length=50)
	private String project;
	
	@Column(name="A_FLAG",length=5)
	private boolean adminFlag;
	
	@Column(name="PWD",length=20)
	private String password;

	public Employee() {

	}

	public Employee(int empId, String userName, String firstName, String lastName, String emailId, String mobileNumber,
			String birthDate, String joiningDate, int ctc, String project, boolean adminFlag, String password) {
		super();
		this.empId = empId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;
		this.ctc = ctc;
		this.project = project;
		this.adminFlag = adminFlag;
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthJoining() {
		return joiningDate;
	}

	public void setBirthJoining(String birthJoining) {
		this.joiningDate = birthJoining;
	}

	public int getCtc() {
		return ctc;
	}

	public void setCtc(int ctc) {
		this.ctc = ctc;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public boolean isAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", birthDate=" + birthDate
				+ ", joiningDate=" + joiningDate + ", ctc=" + ctc + ", project=" + project + ", adminFlag="
				+ adminFlag + ", password=" + password + "]";
	}
	
}
