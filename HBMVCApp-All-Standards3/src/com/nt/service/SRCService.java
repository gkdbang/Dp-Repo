package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.SRCDAO;
import com.nt.dao.SRCDAOFactory;
import com.nt.dto.StudentDTO;

public class SRCService {
  
	public String generateResult(StudentDTO dto){
		int total=0;
		float avg=0.0f;
		String result=null;
		SRCDAO dao=null;
		int count=0;
		StudentBO bo=null;
		//calc total,avg and generate result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg>=35)
			result="pass";
		else
			result="fail";
		//prepare BO/Domain class obj having data to persisted
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		//use dAO
		dao=SRCDAOFactory.getInstance();
		count=dao.insert(bo);
		
		if(count==1)
			return result+" Student Registration successful";
		else
			return result+" student registration failed";
	}//generateResult
}//class

