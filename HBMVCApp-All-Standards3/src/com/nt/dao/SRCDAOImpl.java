package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.bo.StudentBO;
import com.nt.utility.HibernateUtil;

public class SRCDAOImpl implements SRCDAO {

	@Override
	public int insert(StudentBO bo) {
		Session ses=null;
		Transaction tx=null;
		int cnt=0;
		//get Session
		ses=HibernateUtil.getSession();
		//write persistence logic
		try{
		tx=ses.beginTransaction();
		  ses.save(bo);
		tx.commit();
		cnt=1;
		}
		catch(Exception e){
			cnt=0;
		}
		HibernateUtil.closeSession();
		return cnt;
	}//method

}//class
