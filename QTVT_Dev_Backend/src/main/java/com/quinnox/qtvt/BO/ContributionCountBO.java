package com.quinnox.qtvt.BO;

import java.util.HashMap;
import java.util.Map;

public class ContributionCountBO {
	private String grade;
	private Map<String , String> count;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Map<String, String> getCount() {
		return count;
	}
	public void setCount(Map<String, String> count) {
		this.count = count;
	}
	public ContributionCountBO() {
		super();
		this.count = new HashMap<String, String>();
	}

}
