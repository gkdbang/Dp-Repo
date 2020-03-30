package com.quinnox.qtvt.BO;



public class QTVTFormBO {

private String empId;

private String skillClass;

private String skills;

private String pocProject;

private String fromDate;

private String toDate;

private String submissionDate;

private String numberOfHours;

private String empEmail;

private String contactNumber;

private String userComments;

private String empName;



public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmpEmail() {
	return empEmail;
}

public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}

public String getEmpId() {
	return empId;
}

public void setEmpId(String empId) {
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

public String getFromDate() {
	return fromDate;
}

public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}

public String getToDate() {
	return toDate;
}

public void setToDate(String toDate) {
	this.toDate = toDate;
}



public String getSubmissionDate() {
	return submissionDate;
}

public void setSubmissionDate(String submissionDate) {
	this.submissionDate = submissionDate;
}

public String getNumberOfHours() {
	return numberOfHours;
}

public void setNumberOfHours(String numberOfHours) {
	this.numberOfHours = numberOfHours;
}


public String getContactNumber() {
	return contactNumber;
}

public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}


public String getUserComments() {
	return userComments;
}

public void setUserComments(String userComments) {
	this.userComments = userComments;
}



@Override
public String toString() {
	return "QTVTFormBO [empId=" + empId + ", skillClass=" + skillClass + ", skills=" + skills + ", pocProject="
			+ pocProject + ", fromDate=" + fromDate + ", toDate=" + toDate + ", submissionDate=" + submissionDate
			+ ", numberOfHours=" + numberOfHours + ", empEmail=" + empEmail + ", contactNumber=" + contactNumber
			+ ", userComments=" + userComments + ", empName=" + empName + "]";
}


}
