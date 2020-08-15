package com.quinnox.qtvt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.qtvt.model.QTVTform;
import com.quinnox.qtvt.model.SkillClass;
import com.quinnox.qtvt.repository.SkillRepository;
import com.quinnox.qtvt.service.SkillClassService;

@Service("SkillClassService")

public class SkillClassServiceImpl implements SkillClassService {
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public List<SkillClass> getSkillClass() {
		
		return skillRepository.findAll();
	}

	@Override
	public SkillClass saveSkill(SkillClass skillClass) {
		
		SkillClass sClass = skillRepository.findSkillById(skillClass.getSkillId());
		if(sClass!=null) {
		return skillRepository.save(skillClass);
		}
		else
			return skillRepository.save(skillClass);
	}

	@Override
	public boolean removeSkill(long skillId) {
	 SkillClass s=skillRepository.findSkillById(skillId);
	 if(s!=null) {
		skillRepository.delete(s);
		return true;
	 }
		
		return false;
	}

}
