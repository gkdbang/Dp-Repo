package com.nt.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nt.utility.HibernateUtil;

public class SessionFactoryClosingContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Servltcontext obj destroyed");
		HibernateUtil.closeSessionFactory();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Servletcontext obj is created");

	}

}
