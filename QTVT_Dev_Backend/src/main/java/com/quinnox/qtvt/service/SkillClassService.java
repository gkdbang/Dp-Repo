package com.quinnox.qtvt.service;

import java.util.List;

import com.quinnox.qtvt.model.SkillClass;

public interface SkillClassService {
	List<SkillClass> getSkillClass();
	SkillClass saveSkill(SkillClass skillClass);
	boolean removeSkill(long skillId);
}
