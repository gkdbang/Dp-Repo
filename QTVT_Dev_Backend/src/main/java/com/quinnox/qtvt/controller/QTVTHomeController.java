package com.quinnox.qtvt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.quinnox.qtvt.BO.HomePluckCardBO;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.service.QTVTFormService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class QTVTHomeController {

	@Autowired
	QTVTFormService qtvtFormService;
	
	//fetching all submitted,lapsed,allocated hours of individual 
	@RequestMapping(value = {"/HomePage" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> HomePage(@RequestBody Employee emp) {
		try {
			
			HomePluckCardBO pluckCardBO =qtvtFormService.findUserForms(emp);
			
			return new ResponseEntity<Object>(pluckCardBO, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
