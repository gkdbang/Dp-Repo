package com.quinnox.qtvt.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.quinnox.qtvt.service.QTVTFormService;

@Component
public class UpdateStatus {
	@Autowired
	private QTVTFormService formService;
	@Scheduled(cron = "0 0 12 * * SUN")
	public void changeStatus(){
		formService.updateAllStatus();
	}

}
