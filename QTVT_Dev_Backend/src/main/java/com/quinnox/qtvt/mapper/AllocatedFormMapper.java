package com.quinnox.qtvt.mapper;


import com.quinnox.qtvt.BO.QTVTAllocationBO;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.QTVTform;

public class AllocatedFormMapper {
	
public static QTVTform allocatedMapper(QTVTAllocationBO formBO) {
	QTVTform form=new QTVTform();
	form.setFormId(Integer.parseInt(formBO.getFormId()));
	form.setAllocatedHours(Integer.parseInt(formBO.getAllocatedHours()));
	if(formBO.getAllocatedManager()==null) {
		form.setAllocatedManager("");
	}
	else {
		form.setAllocatedManager(formBO.getAllocatedManager());
	}
	
if(formBO.getAllocatedManagersEmail()==null) {
	form.setAllocatedManagersEmail("");
	}
	else {
		form.setAllocatedManagersEmail(formBO.getAllocatedManagersEmail());
	}
if(formBO.getAllocatedProject()==null) {
	form.setAllocatedProject("");
	}
	else {
		form.setAllocatedProject(formBO.getAllocatedProject());
	}
	
if(formBO.getAllocatedSkills()==null) {
	form.setAllocatedSkills("");
	}
	else {
		form.setAllocatedSkills(formBO.getAllocatedSkills());
	}
	
if(formBO.getRmgComments()==null) {
	form.setRmgComments(Constants.NO_COMMENTS);
	}
	else {
		form.setRmgComments(formBO.getRmgComments());
	}
	form.setStatus(formBO.getStatus());
	return form;
}
}
