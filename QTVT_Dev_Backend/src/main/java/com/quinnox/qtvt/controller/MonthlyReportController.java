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

import com.quinnox.qtvt.BO.HistoryBO;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.mapper.MonthlyReportReverseMapper;
import com.quinnox.qtvt.model.QTVTform;
import com.quinnox.qtvt.service.QTVTFormService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class MonthlyReportController {
	
	
	
	@Autowired
	QTVTFormService qtvtFormService;

	// Monthly Report in admin page
	@RequestMapping(value = { "/MonthlyReport" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> MonthlyReport() {
		try {

			List<QTVTform> allFormsList = qtvtFormService.getAllForms();
			
			return new ResponseEntity<Object>(MonthlyReportReverseMapper.mapBo(allFormsList), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//monthly report filters
	@RequestMapping(value = { "/getByFilters" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> getByFilters(@RequestBody HistoryBO historyBO) {
		try {

			List<QTVTform> empForms = qtvtFormService.getByFilters(historyBO);
			
			return new ResponseEntity<Object>(MonthlyReportReverseMapper.mapBoWithFilters(empForms,historyBO.getFromDate(),historyBO.getToDate()), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Object>(Constants.NOTAUTHERIZED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
