package com.quinnox.qtvt.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.qtvt.BO.ContributionCountBO;
import com.quinnox.qtvt.BO.HistoryBO;
import com.quinnox.qtvt.BO.PieChartBO;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.service.QTVTFormService;

@RestController
@CrossOrigin(origins = "http://qtvt.quinnox.com")
@RequestMapping("/admin")
public class AdminDashboardController {
	
	@Autowired
	private QTVTFormService qtvtFormService;
	
	@PostMapping("/searchHoursBwDate")
	public ResponseEntity<List<PieChartBO>> searchHoursBwDate(@RequestBody HistoryBO historyBO) throws ParseException{
	    
	    //Date fromDate1=sdf.parse(historyBO.getFromDate());
	    
		//Date toDate1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(historyBO.getToDate());
		
		List list=qtvtFormService.searchHoursBwDate(historyBO.getFromDate(), historyBO.getToDate());
		
		
		return ResponseEntity.ok().body(list);
		
	}
	//api to get matrix data of contribution based on employee count and hour counts returned based on parameter
	@PostMapping("/getEmployeeCountBwDate")
	public ResponseEntity<List<ContributionCountBO>> getEmployeeCountBwDate(@RequestBody HistoryBO historyBO, @RequestParam String parameter){
		if(parameter.equalsIgnoreCase(Constants.empCount)|| parameter.equalsIgnoreCase(Constants.hourCount)) {
		List< ContributionCountBO> list=qtvtFormService.getContributionCountBwDate(historyBO.getFromDate(), historyBO.getToDate(),parameter);
		return ResponseEntity.ok().body(list);
		}
		return ResponseEntity.badRequest().body(null);
		
		
	}
	
	//api to get matrix data of contribution hours based on location
	@PostMapping("/getLocationCountBwDate")
	public ResponseEntity<List<ContributionCountBO>> getLocationCountBwDate(@RequestBody HistoryBO historyBO){
		
	  List<ContributionCountBO> list=qtvtFormService.getLocationCountBwDate(historyBO.getFromDate(), historyBO.getToDate());
		return ResponseEntity.ok().body(list);
	}
	
	

}
