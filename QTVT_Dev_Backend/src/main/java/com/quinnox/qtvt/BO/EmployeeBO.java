package com.quinnox.qtvt.BO;



public class EmployeeBO {
	private String empEmail;
	private String empManager;
	private String empName;
	private String empDesignation;
	private String empId;
	private String empLocation;
	private boolean roleType;
	private int role;
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpManager() {
		return empManager;
	}
	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
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
	public boolean getRoleType() {
		return roleType;
	}
	public void setRoleType(boolean roleType) {
		this.roleType = roleType;
	}
	@Override
	public String toString() {
		return "EmployeeBO [empEmail=" + empEmail + ", empManager=" + empManager + ", empName=" + empName
				+ ", empDesignation=" + empDesignation + ", empId=" + empId + ", empLocation=" + empLocation
				+ ", roleType=" + roleType + ", role=" + role + "]";
	}
	
	
	

}
