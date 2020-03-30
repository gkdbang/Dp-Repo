package com.quinnox.qtvt.service;

import java.util.List;
import java.util.Map;



import com.quinnox.qtvt.BO.EmployeeBO;
import com.quinnox.qtvt.model.Employee;

public interface EmployeeService {

	Employee findUserByEmail(String lowerCase);
	
	Employee findUserByDisplayname(String lowerCase);

	void createUserdata(Map<String, String> ldapUserMap);

	Employee findUserById(String bean);

	List<EmployeeBO> getAllEmployees();
	
	List<EmployeeBO> getAllEmployeesAdmin();

	List<Employee> findUserByUserId(List<EmployeeBO> employeeBOs);

	
	
	

}
