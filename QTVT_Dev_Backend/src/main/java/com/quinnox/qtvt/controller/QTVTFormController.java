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
import com.quinnox.qtvt.BO.QTVTAllocationBO;
import com.quinnox.qtvt.BO.QTVTFormBO;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.mapper.AllocatedFormMapper;
import com.quinnox.qtvt.mapper.MonthlyReportReverseMapper;
import com.quinnox.qtvt.mapper.QTVTFormMapper;
import com.quinnox.qtvt.model.QTVTform;
import com.quinnox.qtvt.service.EmployeeService;
import com.quinnox.qtvt.service.QTVTFormService;
import com.quinnox.qtvt.util.Email;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class QTVTFormController {
	@Autowired
	private QTVTFormService qtvtFormService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Email email;
	
	//Employee QTVT Form Page
	@RequestMapping(value = {"/QTVTForm" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> qtvtForm(@RequestBody QTVTFormBO formBO) {
		try {
			QTVTform qtvTform=QTVTFormMapper.qtvtMapper(formBO);
			email.sendRegistrationMail(formBO.getEmpEmail(), formBO.getFromDate(), formBO.getToDate(), formBO.getEmpId(), formBO.getEmpName(), formBO.getSkills(), formBO.getNumberOfHours()+"/"+qtvTform.getSubmittedHours());
			return new ResponseEntity<Object>(qtvtFormService.insert(qtvTform), HttpStatus.OK);
		}catch(NullPointerException e) 
        { 
			return new ResponseEntity<Object>(Constants.NULLPOINTEREXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	//Form Allocation 1st page
	@RequestMapping(value = {"/QTVTFormAllocation" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> qtvtFormAllocation() {
		try {
			qtvtFormService.updateAllStatus();
		List<QTVTform> listOfAllForms =qtvtFormService.getAllQtvtForm();
			return new ResponseEntity<Object>(MonthlyReportReverseMapper.allocationBo(listOfAllForms), HttpStatus.OK);
		}catch(NullPointerException e) 
        { 
			return new ResponseEntity<Object>(Constants.NULLPOINTEREXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Form Allocation PopUp Page
	
	@RequestMapping(value = {"/QTVTFormAllocationMain" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> qtvtFormAllocationMainPage(@RequestBody QTVTAllocationBO allocationBO) {
		try {
			QTVTform tform1 = AllocatedFormMapper.allocatedMapper(allocationBO); 
			QTVTform tform = qtvtFormService.findUserByFormId(tform1);
			if(allocationBO.getStatus().equalsIgnoreCase(Constants.ASSIGNED)){
				
			email.sendAllocationMail(tform.getEmpId().getEmpEmail(), tform.getFromDate(), tform.getToDate(), tform.getEmpId(), tform.getEmpId().getEmpName(), allocationBO.getAllocatedSkills(), tform1.getRmgComments(),allocationBO.getAllocatedManager(),tform.getAllocatedManagersEmail());
			}
			return new ResponseEntity<Object>(tform, HttpStatus.OK);
		}catch(NullPointerException e) 
        { 
			return new ResponseEntity<Object>(Constants.NULLPOINTEREXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//For fetching all employees to assign the manager in qtvt form
	@RequestMapping(value = {"/AllEmployeeDetails" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> ListOfEmployees() {
		try {
			List<EmployeeBO> allEmployees= employeeService.getAllEmployees();
			return new ResponseEntity<Object>(allEmployees, HttpStatus.OK);
		}catch(NullPointerException e) 
        { 
			return new ResponseEntity<Object>(Constants.NULLPOINTEREXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	//Admin page Emp list
	@RequestMapping(value = {"/AllEmployeeDetailsAdmin" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> ListOfEmployeesAdmin() {
		try {
			List<EmployeeBO> allEmployees= employeeService.getAllEmployeesAdmin();
			return new ResponseEntity<Object>(allEmployees, HttpStatus.OK);
		}catch(NullPointerException e) 
        { 
			return new ResponseEntity<Object>(Constants.NULLPOINTEREXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
