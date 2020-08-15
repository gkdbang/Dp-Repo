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
import com.quinnox.qtvt.BO.EmployeeBO;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.service.EmployeeService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class SuperAdminController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	//mapping users as admin by superadmin
	@RequestMapping(value = {"/AdminMapping" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> AdminMapping(@RequestBody List<EmployeeBO> employeeList) {
		try {
			List<Employee> emp=employeeService.findUserByUserId(employeeList);
			return new ResponseEntity<Object>(emp, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
