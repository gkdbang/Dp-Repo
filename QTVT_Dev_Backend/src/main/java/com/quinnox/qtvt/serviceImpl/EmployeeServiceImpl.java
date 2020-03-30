package com.quinnox.qtvt.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.qtvt.BO.EmployeeBO;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.Employee;

import com.quinnox.qtvt.repository.EmployeeRepository;
import com.quinnox.qtvt.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
 
	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public Employee findUserByEmail(String email) {
		List<Employee> emp = employeeRepository.findUserByEmail(email);
		if(!emp.isEmpty()) {
			return emp.get(0);
		}
		else {
			return null;
		}

	}
	
	@Override
	public Employee findUserByDisplayname(String displayName) {
		List<Employee> emp = employeeRepository.findUserByDisplayname(displayName);
		if(!emp.isEmpty()) {
			return emp.get(0);
		}
		else {
			return null;
		}

	}
	

	@Override
	public void createUserdata(Map<String, String> ldapUserMap) {
		Employee employee = new Employee();
		employee.setEmpName(ldapUserMap.get("name"));
		employee.setEmpId(ldapUserMap.get("employeeNumber"));
		employee.setEmpEmail(ldapUserMap.get("mail"));
		employee.setEmpManager(ldapUserMap.get("manager").split("CN=")[1].split(",")[0]);
		employee.setEmpDesignation(ldapUserMap.get("title"));
		employee.setEmpLocation(ldapUserMap.get("location"));
		employeeRepository.save(employee);

	}


	@Override
	public Employee findUserById(String username) {
		List<Employee> emp = employeeRepository.findUserById(username);
		if(!emp.isEmpty()) {
			return emp.get(0);
		}
		else {
			return null;
		}

	}

	@Override
	public List<EmployeeBO> getAllEmployees() {
		List<Employee> emp = employeeRepository.findAll();
		List<EmployeeBO> employeeBO=new ArrayList<EmployeeBO>();
			for(int i=0;i<emp.size();i++)
			{
				EmployeeBO employeeBO2=new EmployeeBO();
				employeeBO2.setEmpDesignation(emp.get(i).getEmpDesignation());
				employeeBO2.setEmpEmail(emp.get(i).getEmpEmail());
				employeeBO2.setEmpId(emp.get(i).getEmpId());
				employeeBO2.setEmpLocation(emp.get(i).getEmpLocation());
				employeeBO2.setEmpManager(emp.get(i).getEmpManager());
				employeeBO2.setEmpName(emp.get(i).getEmpName());
				if(emp.get(i).getRole()==Constants.ADMIN)
				{
					employeeBO2.setRole(Constants.ADMIN);
					employeeBO2.setRoleType(true);
				}
				else {
					employeeBO2.setRole(emp.get(i).getRole());
					employeeBO2.setRoleType(false);
					}
				employeeBO.add(employeeBO2);
			}
			return employeeBO;
		
	}

	@Override
	public List<Employee> findUserByUserId(List<EmployeeBO> employeeBOs) {

        List<Employee> employees=new ArrayList<Employee>();
        for(int i=0;i<employeeBOs.size();i++)
        {
               Employee emp=employeeRepository.findUserByEmpId(employeeBOs.get(i).getEmpId());
               if(emp.getRole()==Constants.SUPERADMIN)
               {
                    emp.setRole(Constants.SUPERADMIN);
                    employees.add(employeeRepository.save(emp));
               }

               else if((emp.getEmpId().equals(employeeBOs.get(i).getEmpId())) && (employeeBOs.get(i).getRoleType()==true))
               {
                    emp.setRole(Constants.ADMIN);
                    employees.add(employeeRepository.save(emp));
               }            
               else
               {
                     emp.setRole(Constants.USER);
                     employees.add(employeeRepository.save(emp));
               }
        }
        return employees;
	}

	@Override
	public List<EmployeeBO> getAllEmployeesAdmin() {
		List<Employee> emp = employeeRepository.findAll();
		List<EmployeeBO> employeeBO=new ArrayList<EmployeeBO>();
			for(int i=0;i<emp.size();i++)
			{
				if(emp.get(i).getRole()==Constants.SUPERADMIN)
				{
					continue;
				}
				EmployeeBO employeeBO2=new EmployeeBO();
				employeeBO2.setEmpDesignation(emp.get(i).getEmpDesignation());
				employeeBO2.setEmpEmail(emp.get(i).getEmpEmail());
				employeeBO2.setEmpId(emp.get(i).getEmpId());
				employeeBO2.setEmpLocation(emp.get(i).getEmpLocation());
				employeeBO2.setEmpManager(emp.get(i).getEmpManager());
				employeeBO2.setEmpName(emp.get(i).getEmpName());
				if(emp.get(i).getRole()==Constants.ADMIN)
				{
					employeeBO2.setRole(Constants.ADMIN);
					employeeBO2.setRoleType(true);
				}
				else {
					employeeBO2.setRole(emp.get(i).getRole());
					employeeBO2.setRoleType(false);
					}
				employeeBO.add(employeeBO2);
			}
			return employeeBO;
		
	}                                        	
}