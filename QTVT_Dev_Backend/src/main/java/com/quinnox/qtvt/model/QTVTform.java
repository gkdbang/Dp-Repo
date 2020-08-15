package com.quinnox.qtvt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="QTVTForm")
public class QTVTform implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private long formId;

@ManyToOne(fetch = FetchType.EAGER, optional = false)
@JoinColumn(name = "employeeId", nullable = false)
private Employee empId;

@Column(name = "Skill_Class")
private String skillClass;

@Column(name = "Skill")
private String skills;

@Column(name = "POC_Project")
private String pocProject;

@Column(name = "From_Date")
private Date fromDate;

@Column(name = "To_Date")
private Date toDate;

@Column(name = "Submission_Date")
private Date submissionDate;

@Column(name = "Number_of_Hours")
private long numberOfHours;

@Column(name = "Submitted_Hours")
private long submittedHours;

@Column(name = "Contact_Number")
private String contactNumber;

@Column(name = "Status")
private String status;

@Column(name = "User_Comments")
private String userComments;

@Column(name = "Allocated_Hours")
private long allocatedHours;

@Column(name = "Allocated_Project")
private String allocatedProject;

@Column(name = "Allocated_Manager")
private String allocatedManager;

@Column(name = "Allocated_Managers_Email")
private String allocatedManagersEmail;

@Column(name = "Allocated_Skills")
private String allocatedSkills;

@Column(name = "RMGComments")
private String rmgComments;

public long getFormId() {
	return formId;
}

public void setFormId(long formId) {
	this.formId = formId;
}

public Employee getEmpId() {
	return empId;
}

public void setEmpId(Employee empId) {
	this.empId = empId;
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


public String getRmgComments() {
	return rmgComments;
}

public void setRmgComments(String rmgComments) {
	this.rmgComments = rmgComments;
}

@Override
public String toString() {
	return "QTVTform [formId=" + formId + ", empId=" + empId + ", skillClass=" + skillClass + ", skills=" + skills
			+ ", pocProject=" + pocProject + ", fromDate=" + fromDate + ", toDate=" + toDate + ", submissionDate="
			+ submissionDate + ", numberOfHours=" + numberOfHours + ", submittedHours=" + submittedHours
			+ ", contactNumber=" + contactNumber + ", status=" + status + ", userComments=" + userComments
			+ ", allocatedHours=" + allocatedHours + ", allocatedProject=" + allocatedProject + ", allocatedManager="
			+ allocatedManager + ", allocatedManagersEmail=" + allocatedManagersEmail + ", allocatedSkills="
			+ allocatedSkills + ", rmgComments=" + rmgComments + "]";
}



}
