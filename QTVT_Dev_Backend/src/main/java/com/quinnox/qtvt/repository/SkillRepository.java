package com.quinnox.qtvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.model.SkillClass;

@SuppressWarnings("unused")
@Repository
public interface SkillRepository extends JpaRepository<SkillClass, Long> {
	@Transactional
	@Query("Select skillClass from SkillClass skillClass ")
		List<SkillClass> getSkillClass();

	
	@Transactional
	@Query("Select s from SkillClass s where s.skillId=?1")
	SkillClass findSkillById(long skillId);


}
