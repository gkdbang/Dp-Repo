package com.quinnox.qtvt.controller;

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

import com.quinnox.qtvt.bean.LoginBean;
import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.service.EmployeeService;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080","http://qtvt.quinnox.com","http://10.30.3.15:8080","http://10.30.3.15:80"},allowedHeaders="*")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = {"/login" }, method ={ RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<Object> login(@RequestBody LoginBean loginBean) {
		Employee employee=new Employee();
	try {
	employee = employeeService.findUserByEmail(loginBean.getUsername());
	return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}catch(Exception e) {
		employee=null;
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}		
	}
	
	@RequestMapping(value = {"/login2" }, method ={ RequestMethod.GET })
	@ResponseBody
	public ResponseEntity<Object> login2(@RequestParam(name = "id") String fooId, @RequestParam(name = "password") String name) {
		Employee employee=new Employee();
	try {
	System.out.println("fooId"+fooId);
	System.out.println("3"+name);
	return new ResponseEntity<Object>("it works", HttpStatus.OK);
	}catch(Exception e) {
		employee=null;
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}		
	}
	
	
	
	
}
