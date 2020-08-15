package com.quinnox.qtvt.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quinnox.qtvt.BO.MonthlyReportBO;
import com.quinnox.qtvt.model.QTVTform;
import com.quinnox.qtvt.util.WorkingDays;

public class MonthlyReportReverseMapper {
	private static Logger logger=LoggerFactory.getLogger(MonthlyReportReverseMapper.class);
	public static List<MonthlyReportBO> allocationBo(List<QTVTform> qtvtForm){

		List<MonthlyReportBO> monthlyReportBOs=new ArrayList<MonthlyReportBO>();
		for(QTVTform qtvtForm2:qtvtForm){ 
			MonthlyReportBO monthlyReportBO=new MonthlyReportBO();
			monthlyReportBO.setAllocatedHours(qtvtForm2.getAllocatedHours());
			monthlyReportBO.setAllocatedManager(qtvtForm2.getAllocatedManager());
			monthlyReportBO.setAllocatedManagersEmail(qtvtForm2.getAllocatedManagersEmail());
			monthlyReportBO.setAllocatedProject(qtvtForm2.getAllocatedProject());
			monthlyReportBO.setAllocatedSkills(qtvtForm2.getAllocatedSkills());
			monthlyReportBO.setContactNumber(qtvtForm2.getContactNumber());
			monthlyReportBO.setEmpDesignation(qtvtForm2.getEmpId().getEmpDesignation());
			monthlyReportBO.setEmpEmail(qtvtForm2.getEmpId().getEmpEmail());
			monthlyReportBO.setEmpId(qtvtForm2.getEmpId().getEmpId());
			monthlyReportBO.setEmpLocation(qtvtForm2.getEmpId().getEmpLocation());
			monthlyReportBO.setEmpManager(qtvtForm2.getEmpId().getEmpManager());
			monthlyReportBO.setEmpName(qtvtForm2.getEmpId().getEmpName());
			monthlyReportBO.setFormId(qtvtForm2.getFormId());
			monthlyReportBO.setFromDate(qtvtForm2.getFromDate());
			monthlyReportBO.setNumberOfHours(qtvtForm2.getNumberOfHours());
			monthlyReportBO.setPocProject(qtvtForm2.getPocProject());
			monthlyReportBO.setRmgComments(qtvtForm2.getRmgComments());
			monthlyReportBO.setSkillClass(qtvtForm2.getSkillClass());
			monthlyReportBO.setSkills(qtvtForm2.getSkills());
			monthlyReportBO.setStatus(qtvtForm2.getStatus());
			monthlyReportBO.setSubmittedHours(qtvtForm2.getSubmittedHours());
			monthlyReportBO.setSubmissionDate(qtvtForm2.getSubmissionDate());
			monthlyReportBO.setToDate(qtvtForm2.getToDate());
			monthlyReportBO.setUserComments(qtvtForm2.getUserComments());
			monthlyReportBOs.add(monthlyReportBO);
		}
		return monthlyReportBOs;

	}
	public static List<MonthlyReportBO> mapBo(List<QTVTform> qtvtForm){

		List<MonthlyReportBO> monthlyReportBOs=new ArrayList<MonthlyReportBO>();
		for(QTVTform qtvtForm2:qtvtForm){ 
			MonthlyReportBO monthlyReportBO=new MonthlyReportBO();
			long allocatedHoursPerDay=0;
			long numberOfworkingDays=0;
			monthlyReportBO.setAllocatedHours(qtvtForm2.getAllocatedHours());
			monthlyReportBO.setAllocatedManager(qtvtForm2.getAllocatedManager());
			monthlyReportBO.setAllocatedManagersEmail(qtvtForm2.getAllocatedManagersEmail());
			monthlyReportBO.setAllocatedProject(qtvtForm2.getAllocatedProject());
			monthlyReportBO.setAllocatedSkills(qtvtForm2.getAllocatedSkills());
			monthlyReportBO.setContactNumber(qtvtForm2.getContactNumber());
			monthlyReportBO.setEmpDesignation(qtvtForm2.getEmpId().getEmpDesignation());
			monthlyReportBO.setEmpEmail(qtvtForm2.getEmpId().getEmpEmail());
			monthlyReportBO.setEmpId(qtvtForm2.getEmpId().getEmpId());
			monthlyReportBO.setEmpLocation(qtvtForm2.getEmpId().getEmpLocation());
			monthlyReportBO.setEmpManager(qtvtForm2.getEmpId().getEmpManager());
			monthlyReportBO.setEmpName(qtvtForm2.getEmpId().getEmpName());
			monthlyReportBO.setFormId(qtvtForm2.getFormId());
			monthlyReportBO.setFromDate(qtvtForm2.getFromDate());
			monthlyReportBO.setNumberOfHours(qtvtForm2.getNumberOfHours());
			monthlyReportBO.setPocProject(qtvtForm2.getPocProject());
			monthlyReportBO.setRmgComments(qtvtForm2.getRmgComments());
			monthlyReportBO.setSkillClass(qtvtForm2.getSkillClass());
			monthlyReportBO.setSkills(qtvtForm2.getSkills());
			monthlyReportBO.setStatus(qtvtForm2.getStatus());
			monthlyReportBO.setSubmissionDate(qtvtForm2.getSubmissionDate());
			monthlyReportBO.setSubmittedHours(qtvtForm2.getSubmittedHours());
			monthlyReportBO.setToDate(qtvtForm2.getToDate());
			monthlyReportBO.setUserComments(qtvtForm2.getUserComments());
			monthlyReportBO.setProRatedAllocatedHours(allocatedHoursPerDay);
			monthlyReportBO.setProRatedSubmittedHours(numberOfworkingDays*qtvtForm2.getNumberOfHours());
			monthlyReportBOs.add(monthlyReportBO);
		}
		return monthlyReportBOs;

	}

	public static List<MonthlyReportBO> mapBoWithFilters(List<QTVTform> qtvtForm,Date fromDate,Date toDate){
		int count=0;
		List<MonthlyReportBO> monthlyReportBOs=new ArrayList<MonthlyReportBO>();
		for(QTVTform qtvtForm2:qtvtForm){ 
			MonthlyReportBO monthlyReportBO=new MonthlyReportBO();
			double allocatedHoursPerDay=0;
			long numberOfworkingDays=0;
			if(fromDate!= null){
				numberOfworkingDays=numberOfDaysInTheRange(fromDate, toDate, qtvtForm2.getFromDate(), qtvtForm2.getToDate());
				if(qtvtForm2.getAllocatedHours()!=0){
					allocatedHoursPerDay=((double)qtvtForm2.getAllocatedHours()/WorkingDays.getWorkingDaysBetweenTwoDates(qtvtForm2.getFromDate(), qtvtForm2.getToDate()));
					logger.info("allocatedHoursPerDay:"+allocatedHoursPerDay);
					logger.info("number of hours:"+numberOfworkingDays);
					logger.info("count:"+count++);
				}
			}
			monthlyReportBO.setAllocatedHours(qtvtForm2.getAllocatedHours());
			monthlyReportBO.setAllocatedManager(qtvtForm2.getAllocatedManager());
			monthlyReportBO.setAllocatedManagersEmail(qtvtForm2.getAllocatedManagersEmail());
			monthlyReportBO.setAllocatedProject(qtvtForm2.getAllocatedProject());
			monthlyReportBO.setAllocatedSkills(qtvtForm2.getAllocatedSkills());
			monthlyReportBO.setContactNumber(qtvtForm2.getContactNumber());
			monthlyReportBO.setEmpDesignation(qtvtForm2.getEmpId().getEmpDesignation());
			monthlyReportBO.setEmpEmail(qtvtForm2.getEmpId().getEmpEmail());
			monthlyReportBO.setEmpId(qtvtForm2.getEmpId().getEmpId());
			monthlyReportBO.setEmpLocation(qtvtForm2.getEmpId().getEmpLocation());
			monthlyReportBO.setEmpManager(qtvtForm2.getEmpId().getEmpManager());
			monthlyReportBO.setEmpName(qtvtForm2.getEmpId().getEmpName());
			monthlyReportBO.setFormId(qtvtForm2.getFormId());
			monthlyReportBO.setFromDate(qtvtForm2.getFromDate());
			monthlyReportBO.setNumberOfHours(qtvtForm2.getNumberOfHours());
			monthlyReportBO.setPocProject(qtvtForm2.getPocProject());
			monthlyReportBO.setRmgComments(qtvtForm2.getRmgComments());
			monthlyReportBO.setSkillClass(qtvtForm2.getSkillClass());
			monthlyReportBO.setSkills(qtvtForm2.getSkills());
			monthlyReportBO.setStatus(qtvtForm2.getStatus());
			monthlyReportBO.setSubmissionDate(qtvtForm2.getSubmissionDate());
			monthlyReportBO.setSubmittedHours(qtvtForm2.getSubmittedHours());
			monthlyReportBO.setToDate(qtvtForm2.getToDate());
			monthlyReportBO.setUserComments(qtvtForm2.getUserComments());
			monthlyReportBO.setProRatedAllocatedHours(Math.round((allocatedHoursPerDay*numberOfworkingDays)));
			monthlyReportBO.setProRatedSubmittedHours(numberOfworkingDays*qtvtForm2.getNumberOfHours());
			monthlyReportBOs.add(monthlyReportBO);
		}
		return monthlyReportBOs;

	}

	private static long numberOfDaysInTheRange(Date fromDate,Date toDate,Date qtvtFromDate,Date qtvtToDate){
		if(fromDate.before(qtvtFromDate) && toDate.after(qtvtToDate) ){
			return WorkingDays.getWorkingDaysBetweenTwoDates(qtvtFromDate, qtvtToDate);
		}  
		else if(fromDate.after(qtvtFromDate)){
			if(toDate.after(qtvtToDate)){
				return WorkingDays.getWorkingDaysBetweenTwoDates(fromDate, qtvtToDate);
			}
			else return WorkingDays.getWorkingDaysBetweenTwoDates(fromDate, toDate);
		}
		else if(fromDate.before(qtvtFromDate)){
			if(toDate.after(qtvtToDate)){
				return WorkingDays.getWorkingDaysBetweenTwoDates(qtvtFromDate, qtvtToDate);
			}
			else return WorkingDays.getWorkingDaysBetweenTwoDates(qtvtFromDate, toDate);
		}
		else return WorkingDays.getWorkingDaysBetweenTwoDates(fromDate, toDate);
	}

}