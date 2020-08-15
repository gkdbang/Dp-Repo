package com.quinnox.qtvt.service;

import java.util.Date;
import java.util.List;

import com.quinnox.qtvt.BO.ContributionCountBO;
import com.quinnox.qtvt.BO.HistoryBO;
import com.quinnox.qtvt.BO.HomePluckCardBO;
import com.quinnox.qtvt.BO.PieChartBO;

import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.model.QTVTform;

public interface QTVTFormService {
	
	QTVTform insert(QTVTform qtvTform);

	List<QTVTform> getAllQtvtForm();
	
	QTVTform findUserByFormId(QTVTform qtvtform);

	HomePluckCardBO findUserForms(Employee emp);

	List<QTVTform> getEmployeeHistroy(Employee emp);

	List<QTVTform> getAllForms();
	
	List<PieChartBO> searchHoursBwDate(Date fromDate,Date toDate);
	
	
	
	
	List<QTVTform> getByFilters(HistoryBO historyBO);

	void updateAllStatus();
	
	List<ContributionCountBO> getContributionCountBwDate(Date fromDate,Date toDate,String parameter);
	
	List<ContributionCountBO> getLocationCountBwDate(Date fromDate,Date toDate);
	

	
	

	
}
