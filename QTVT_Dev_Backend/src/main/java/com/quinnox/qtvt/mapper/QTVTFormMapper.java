package com.quinnox.qtvt.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import com.quinnox.qtvt.BO.QTVTFormBO;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.model.QTVTform;
import com.quinnox.qtvt.util.Email;
import com.quinnox.qtvt.util.WorkingDays;

public class QTVTFormMapper {
	@Autowired
	static
	Email email;
	
	public static QTVTform qtvtMapper(QTVTFormBO formBO) throws ParseException {
		QTVTform form=new QTVTform();
		form.setContactNumber(formBO.getContactNumber());
		form.setEmpId(new Employee(formBO.getEmpId()));
		form.setFromDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(formBO.getFromDate()));
		form.setNumberOfHours(Integer.parseInt(formBO.getNumberOfHours()));
		if(formBO.getPocProject()==null) {
			form.setPocProject("");
		}
		else {
			form.setPocProject(formBO.getPocProject());
		}
		form.setSkillClass(formBO.getSkillClass());
		form.setSkills(formBO.getSkills());
		form.setStatus(Constants.OPEN);
		form.setSubmissionDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(formBO.getSubmissionDate()));
		form.setToDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(formBO.getToDate()));
		form.setSubmittedHours(WorkingDays.getWorkingDaysBetweenTwoDates(form.getFromDate(), form.getToDate())*form.getNumberOfHours());
		if(formBO.getUserComments()==null) {
			form.setUserComments(Constants.NO_COMMENTS);
		}
		else {
			form.setUserComments(formBO.getUserComments());
		}
		
		return form;
	}

}
