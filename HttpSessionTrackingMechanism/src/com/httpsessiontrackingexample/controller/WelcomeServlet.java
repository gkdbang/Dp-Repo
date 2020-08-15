package com.httpsessiontrackingexample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends
HttpServlet{
	public void doPost(HttpServletRequest req,
			HttpServletResponse res)throws
			ServletException,IOException{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");
		String target="/menus.html";		
RequestDispatcher rd=req.getRequestDispatcher(target);		
	rd.include(req,res);
HttpSession hs=req.getSession(false);	
String userName=(String)hs.getAttribute("userName");	
pw.println("welcome ,"+userName);
	
	}
}
