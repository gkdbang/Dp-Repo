package com.quinnox.qtvt.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.qtvt.BO.ContributionCountBO;
import com.quinnox.qtvt.BO.HistoryBO;
import com.quinnox.qtvt.BO.HomePluckCardBO;
import com.quinnox.qtvt.BO.PieChartBO;

import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.model.QTVTform;
import com.quinnox.qtvt.model.StatusLog;
import com.quinnox.qtvt.repository.QTVTFormRepository;
import com.quinnox.qtvt.repository.StatusLogRepository;
import com.quinnox.qtvt.service.QTVTFormService;

@Service("qtvtformService")
public class QTVTFormServiceImpl implements QTVTFormService {

	@Autowired
	QTVTFormRepository formRepository;

	@Autowired
	StatusLogRepository statusLogRepository;

	@Override
	public QTVTform insert(QTVTform qtvTform) {
		if(qtvTform.getFormId()==0){
			return formRepository.save(qtvTform);
		}
		else {
			return formRepository.save(qtvTform);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QTVTform> getAllQtvtForm() {
		List<QTVTform> qForms = formRepository.getAllQtvtForm();
		System.out.println(qForms.size());
		if(!qForms.isEmpty()) {
			return qForms;
		}
		else {
			return qForms;
		}

	}

	@Override
	public QTVTform findUserByFormId(QTVTform qtvtform) {
		QTVTform qtvTforms = formRepository.findUserByFormId(qtvtform.getFormId());
		if(qtvTforms !=null)
		{
			if(qtvtform.getStatus().equals(Constants.ONHOLD) || qtvtform.getStatus().equals(Constants.REJECTED))
			{
				qtvTforms.setStatus(qtvtform.getStatus());

			} 
			else{
				qtvTforms.setAllocatedHours(qtvtform.getAllocatedHours());
				qtvTforms.setAllocatedProject(qtvtform.getAllocatedProject());
				qtvTforms.setAllocatedSkills(qtvtform.getAllocatedSkills());
				qtvTforms.setStatus(qtvtform.getStatus());
				qtvTforms.setRmgComments(qtvtform.getRmgComments());
				qtvTforms.setAllocatedManager(qtvtform.getAllocatedManager());
				qtvTforms.setAllocatedManagersEmail(qtvtform.getAllocatedManagersEmail());

			}

			StatusLog statusLog=new StatusLog();
			statusLog.setDate(new Date(System.currentTimeMillis()));
			statusLog.setFormId(qtvTforms);
			statusLog.setStatus(qtvtform.getStatus());
			statusLogRepository.save(statusLog); 

			return formRepository.save(qtvTforms);			
		}
		else {
			return qtvTforms;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public HomePluckCardBO findUserForms(Employee empID) {

		List<QTVTform> qtvTform=formRepository.findUserForms(empID);
		HomePluckCardBO pluckCards=new HomePluckCardBO();
		long submmitedHours=0,lapsedHours=0,allocatedHours=0;
		if(qtvTform!=null)
		{
			for(int i=0;i<qtvTform.size();i++)
			{
				submmitedHours=submmitedHours+qtvTform.get(i).getSubmittedHours();
				allocatedHours=allocatedHours+qtvTform.get(i).getAllocatedHours();
				if(qtvTform.get(i).getStatus().equalsIgnoreCase(Constants.ASSIGNED) || qtvTform.get(i).getStatus().equalsIgnoreCase(Constants.LAPSED)) {
					lapsedHours=lapsedHours+(qtvTform.get(i).getSubmittedHours()-qtvTform.get(i).getAllocatedHours());
				}

			}
			/**/
			pluckCards.setAllocatedHours(allocatedHours);
			pluckCards.setLapsedHours(lapsedHours);
			pluckCards.setSubmittedHours(submmitedHours);
			return pluckCards;
		}
		return pluckCards;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QTVTform> getEmployeeHistroy(Employee empId) {
		List<QTVTform> qForms = formRepository.findUserForms(empId);
		return qForms;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QTVTform> getAllForms() {
		List<QTVTform> qForms = formRepository.getAllForms();
		return qForms;
	}

	@Override
	public List<PieChartBO> searchHoursBwDate(Date fromDate,Date toDate) {
		List<QTVTform> qtvTforms=formRepository.searchBwDates(fromDate, toDate);
		System.out.println(qtvTforms.size());
		PieChartBO pieChartBO=new PieChartBO();
		int submmitedHours=0,lapsedHours=0,allocatedHours=0;
		if(!qtvTforms.isEmpty()) {
			for(QTVTform tform : qtvTforms) {
				submmitedHours+=tform.getSubmittedHours();
				allocatedHours+=tform.getAllocatedHours();
			}
			List<PieChartBO>list=new ArrayList<PieChartBO>();
			
			lapsedHours=submmitedHours-allocatedHours;
			
			pieChartBO.setAllocated(allocatedHours);
			pieChartBO.setSubmitted(submmitedHours);
			pieChartBO.setLapsed(lapsedHours);
			list.add(pieChartBO);
			if(allocatedHours==0&&submmitedHours==0&&lapsedHours==0)
				return new ArrayList();
			return list;
			
		}
		return new ArrayList();
	}


	@SuppressWarnings({"unchecked" })
	@Override
	public List<QTVTform> getByFilters(HistoryBO historyBO) {
		Date fromDate=historyBO.getFromDate();
		Date toDate=historyBO.getToDate();
		String status=historyBO.getStatus();
		String skills=historyBO.getSkills();
		List<QTVTform> qtvtforms=new ArrayList<QTVTform>();
		if(fromDate!=null){
			if(!status.equals("")){
				if(!skills.equals("")){
					qtvtforms=formRepository.getByAllFilters(fromDate, toDate, status, skills);
				}
				else qtvtforms=formRepository.getByDateAndStatus(fromDate, toDate, status);
			}
			else if(!skills.equals("")){
				qtvtforms=formRepository.getByDateAndSkills(fromDate, toDate, skills);
			}
			else qtvtforms=formRepository.getByDate(fromDate, toDate);
		}
		else if(!status.equals("")){
			if(!skills.equals("")){
				qtvtforms=formRepository.getByStatusAndSkills(status, skills);
			}
			else qtvtforms=formRepository.getByStatus(status);
		}
		else qtvtforms=formRepository.getBySkills(skills);

		return qtvtforms;
	}

	@Override
	public void updateAllStatus() {
		Date today = Calendar.getInstance().getTime();
		List<QTVTform> list=formRepository.findAllOfToday(today,Constants.ONHOLD,Constants.ASSIGNED,Constants.OPEN);
		list.forEach( element -> {
			if(element.getStatus().equalsIgnoreCase(Constants.ONHOLD) || element.getStatus().equalsIgnoreCase(Constants.OPEN)){
				element.setStatus(Constants.LAPSED);
			}
			else {
				element.setStatus(Constants.UTILIZED);
			}
			StatusLog statusLog=new StatusLog();
			statusLog.setDate(new Date(System.currentTimeMillis()));
			statusLog.setFormId(element);
			statusLog.setStatus(element.getStatus());
			statusLogRepository.save(statusLog); 
			formRepository.save(element);
		});
	}
	
	@Override
	public List<ContributionCountBO> getContributionCountBwDate(Date fromDate, Date toDate,String parameter) {
		// TODO Auto-generated method stub
		List<String> grades=formRepository.getDistinctGrades();
		List<ContributionCountBO> mainList=new ArrayList<ContributionCountBO>();
		boolean isResultEmpty=true;
		System.out.println("Grades: "+grades);
		for(String grade:grades) {
			ContributionCountBO countBO=new ContributionCountBO();
			countBO.setGrade(grade);
			Map<String , String> map=new HashMap<String, String>();
			List<String> skills=formRepository.getDistinctSkills();
			System.out.println("Skills: "+skills);
			if(parameter.equalsIgnoreCase(Constants.empCount)) {
			for(String skill: skills) {
				int count=formRepository.getEmpGradeSkillCount(grade, skill, fromDate, toDate);
				if(isResultEmpty && count!=0)
					isResultEmpty=false;
				map.put(skill, String.valueOf(count));	
			}
			}
			else if(parameter.equalsIgnoreCase(Constants.hourCount)) {
				
				for(String skill: skills) {
				     long count=0;
					List<QTVTform> qtvTforms=formRepository.getHoursGradeSkillCount(grade,skill,fromDate,toDate);
					for(QTVTform form: qtvTforms) {
						count+=form.getSubmittedHours();
					}
					if(isResultEmpty && count!=0)
						isResultEmpty=false;
					map.put(skill, String.valueOf(count));	
				}
				
			}
			
		countBO.setCount(map);
		mainList.add(countBO);
			
		}
		if(isResultEmpty)
			return new ArrayList();
		return mainList;
	}
	
	
	
	@Override
	public List<ContributionCountBO> getLocationCountBwDate(Date fromDate, Date toDate) {
		
		List<String> locations=formRepository.getDistinctLocations();
		List<ContributionCountBO> mainList=new ArrayList<ContributionCountBO>();
		boolean isResultEmpty=true;
		
		System.out.println("locations: "+locations);
		for(String location:locations) {
			ContributionCountBO countBO=new ContributionCountBO();
			countBO.setGrade(location);
			Map<String , String> map=new HashMap<String, String>();
			List<String> skills=formRepository.getDistinctSkills();
			System.out.println("Skills: "+skills);
			
			
				for(String skill: skills) {
				     long count=0;
					List<QTVTform> qtvTforms=formRepository.getHoursLocationSkillCount(location,skill,fromDate,toDate);
					for(QTVTform form: qtvTforms) {
						count+=form.getSubmittedHours();
					}
					if(isResultEmpty && count!=0)
						isResultEmpty=false;
					map.put(skill, String.valueOf(count));	
				}
				
			
			
		countBO.setCount(map);
		mainList.add(countBO);
			
		}
		if(isResultEmpty)
			return new ArrayList();
		return mainList;

	}
	
	
}
