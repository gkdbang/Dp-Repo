package com.quinnox.qtvt.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quinnox.qtvt.model.Employee;



@SuppressWarnings("unused")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{	
	
	
	@Transactional
	@Query("Select employee from Employee employee where employee.empEmail=?1")
		List<Employee> findUserByEmail(String email);
	
	
	@Transactional
	@Query("Select employee from Employee employee where employee.empName=?1")
		List<Employee> findUserByDisplayname(String name);
	
	@Transactional
	@Query("Select employee from Employee employee where employee.empId=?1")
		List<Employee> findUserById(String employeeId);


	@Transactional
	@Query("Select employee from Employee employee where employee.empId=?1")
		Employee findUserByEmpId(String employeeId);
	
	}
