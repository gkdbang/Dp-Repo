package com.quinnox.qtvt.BO;

import java.util.Date;

public class HistoryBO {
	
	private Date toDate;
	private Date fromDate;
	private String status;
	private String skills;
	
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "HistoryBO [toDate=" + toDate + ", fromDate=" + fromDate + ", status=" + status + ", skills=" + skills
				+ "]";
	}
	
	
	

}
