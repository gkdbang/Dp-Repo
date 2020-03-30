package com.quinnox.qtvt.BO;

public class AllocatedFormBO {
	private String formId;
	
	private String allocatedHours;

	private String allocatedProject;

	private String allocatedManager;

	private String allocatedManagersEmail;

	private String allocatedSkills;

	private String RMGComments;
	
	private String empId;
	
	private String empEmail;
	
	private String empName;
	
	private String fromDate;

	private String toDate;
	
	private String skills;
	
	
	
	
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}
	
	public String getAllocatedHours() {
		return allocatedHours;
	}

	public void setAllocatedHours(String allocatedHours) {
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
		return "AllocatedFormBO [formId=" + formId + ", allocatedHours=" + allocatedHours + ", allocatedProject="
				+ allocatedProject + ", allocatedManager=" + allocatedManager + ", allocatedManagersEmail="
				+ allocatedManagersEmail + ", allocatedSkills=" + allocatedSkills + ", RMGComments=" + RMGComments
				+ ", empId=" + empId + ", empEmail=" + empEmail + ", empName=" + empName + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", skills=" + skills + "]";
	}
	
}
