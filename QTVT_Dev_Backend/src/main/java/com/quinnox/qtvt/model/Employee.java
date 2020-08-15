package com.quinnox.qtvt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Employee")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empEmail;
	private String empManager;
	private String empName;
	private String empDesignation;
	@Id
	private String empId;
	private String empLocation;
	private int role=1;
	
	public Employee() {
		
	}
	public Employee(String employeeId) {
		empId=employeeId;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empMail) {
		this.empEmail = empMail;
	}
	public String getEmpManager() {
		return empManager;
	}
	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [empMail=" + empEmail + ", empManager=" + empManager + ", empName=" + empName
				+ ", empDesignation=" + empDesignation + ", empId=" + empId + ", empLocation=" + empLocation + ", role="
				+ role + "]";
	}

	

}
