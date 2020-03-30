package com.quinnox.qtvt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="skillclass")
public class SkillClass implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long skillId;
	
	private String skillClass;
	
	@Column(name = "Skill")
	private String skills;
	

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
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

	@Override
	public String toString() {
		return "SkillClass [skillId=" + skillId + ", skillClass=" + skillClass + ", skills=" + skills + "]";
	}


	

}
