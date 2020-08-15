package com.quinnox.qtvt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.SkillClass;
import com.quinnox.qtvt.repository.SkillRepository;
import com.quinnox.qtvt.service.SkillClassService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class SkillClassCRUDController {
	@Autowired
	SkillClassService skillClassService;
	
	@Autowired
	SkillRepository skillRepository;
	
	static boolean present=false;
	
	@RequestMapping(value = {"/getSkill" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getSkill() {
		try {
			List<SkillClass> skills=skillClassService.getSkillClass();
			return new ResponseEntity<Object>(skills, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = {"/createSkill" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> setSkill(@RequestBody SkillClass skillClass) {
		try {
			skillRepository.findAll().forEach(ele -> {
				if(ele.getSkillClass().equalsIgnoreCase(skillClass.getSkillClass())) {
					present=true;
				}
			});
			if(present) {
				present=false;
				return new ResponseEntity<Object>("Skill class cannot be repeated", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			SkillClass skills=skillClassService.saveSkill(skillClass);
			return new ResponseEntity<Object>(skills, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = {"/updateSkill" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> updateSkill(@RequestBody SkillClass skillClass) {
		try {				
			if(skillClass.getSkillId()==0) {
				return new ResponseEntity<Object>("Id is required to update", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			SkillClass skills=skillClassService.saveSkill(skillClass);
			return new ResponseEntity<Object>(skills, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = {"/removeSkill" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> removeSkill(@RequestParam long skillId) {
		try {
			boolean done=skillClassService.removeSkill(skillId);
			return new ResponseEntity<Object>(done, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
