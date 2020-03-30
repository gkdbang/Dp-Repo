package com.quinnox.qtvt.BO;

public class QTVTAllocationBO {

	private String formId;
	private String allocatedHours;
	private String allocatedProject;
	private String allocatedManager;
	private String allocatedManagersEmail;
	private String allocatedSkills;
	private String rmgComments;
	private String status;
	
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
	
	public String getRmgComments() {
		return rmgComments;
	}
	public void setRmgComments(String rmgComments) {
		this.rmgComments = rmgComments;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "QTVTAllocationBO [formId=" + formId + ", allocatedHours=" + allocatedHours + ", allocatedProject="
				+ allocatedProject + ", allocatedManager=" + allocatedManager + ", allocatedManagersEmail="
				+ allocatedManagersEmail + ", allocatedSkills=" + allocatedSkills + ", rmgComments=" + rmgComments
				+ ", status=" + status +  "]";
	}
	
	
	
}
