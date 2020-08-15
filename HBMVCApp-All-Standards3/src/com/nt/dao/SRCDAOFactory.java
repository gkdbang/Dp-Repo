package com.nt.dao;

public class SRCDAOFactory {
	
	public static SRCDAO getInstance(){
		return new SRCDAOImpl();
	}

}
