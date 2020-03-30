package com.quinnox.qtvt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.model.QTVTform;
import com.quinnox.qtvt.service.QTVTFormService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeHistoryController {

	@Autowired
	QTVTFormService qtvtFormService;

	// Individual employee histroy
	@RequestMapping(value = { "/EmployeeHistroy" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> EmployeeHistroy(@RequestBody Employee emp) {
		try {

			List<QTVTform> empForms = qtvtFormService.getEmployeeHistroy(emp);

			return new ResponseEntity<Object>(empForms, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
