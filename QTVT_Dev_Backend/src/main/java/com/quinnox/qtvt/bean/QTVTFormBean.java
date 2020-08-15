package com.quinnox.qtvt.bean;

import java.util.Date;




public class QTVTFormBean {

	private String empEmail;
	private String empManager;
	private String empName;
	private String empDesignation;
	private String empId;
	private String empLocation;
	private int role=1;
	private String skillClass;
	private String skills;
	private String pocProject;
	private Date fromDate;
	private Date toDate;
	private Date submissionDate;
	private long numberOfHours;
	private long submittedHours;
	private String contactNumber;
	private String status;
	private String userComments;
	private long allocatedHours;
	private String allocatedProject;
	private String allocatedManager;
	private String allocatedManagersEmail;
	private String allocatedSkills;
	private String RMGComments;
	
	
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
	public String getSkillClass() {
		return skillClass;
	}
	public void setSkillClass(String skillClass) {
		this.skillClass = skillClass;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getPocProject() {
		return pocProject;
	}
	public void setPocProject(String pocProject) {
		this.pocProject = pocProject;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public long getNumberOfHours() {
		return numberOfHours;
	}
	public void setNumberOfHours(long numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	public long getSubmittedHours() {
		return submittedHours;
	}
	public void setSubmittedHours(long submittedHours) {
		this.submittedHours = submittedHours;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserComments() {
		return userComments;
	}
	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}
	public long getAllocatedHours() {
		return allocatedHours;
	}
	public void setAllocatedHours(long allocatedHours) {
		this.allocatedHours = allocatedHours;
	}
	public String getAllocatedProject() {
		return allocatedProject;
	}
	public void setAllocatedProject(String allocatedProject) {
		this.allocatedProject = allocatedProject;
	}
	public String getAllocatedManager() {
		return allocatedManager;
	}
	public void setAllocatedManager(String allocatedManager) {
		this.allocatedManager = allocatedManager;
	}
	public String getAllocatedManagersEmail() {
		return allocatedManagersEmail;
	}
	public void setAllocatedManagersEmail(String allocatedManagersEmail) {
		this.allocatedManagersEmail = allocatedManagersEmail;
	}
	public String getAllocatedSkills() {
		return allocatedSkills;
	}
	public void setAllocatedSkills(String allocatedSkills) {
		this.allocatedSkills = allocatedSkills;
	}
	public String getRMGComments() {
		return RMGComments;
	}
	public void setRMGComments(String rMGComments) {
		RMGComments = rMGComments;
	}
	@Override
	public String toString() {
		return "QTVTFormBean [empEmail=" + empEmail + ", empManager=" + empManager + ", empName=" + empName
				+ ", empDesignation=" + empDesignation + ", empId=" + empId + ", empLocation=" + empLocation + ", role="
				+ role + ", skillClass=" + skillClass + ", skills=" + skills + ", pocProject=" + pocProject
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", submissionDate=" + submissionDate
				+ ", numberOfHours=" + numberOfHours + ", submittedHours=" + submittedHours + ", contactNumber="
				+ contactNumber + ", status=" + status + ", userComments=" + userComments + ", allocatedHours="
				+ allocatedHours + ", allocatedProject=" + allocatedProject + ", allocatedManager=" + allocatedManager
				+ ", allocatedManagersEmail=" + allocatedManagersEmail + ", allocatedSkills=" + allocatedSkills
				+ ", RMGComments=" + RMGComments + "]";
	}
	
}
