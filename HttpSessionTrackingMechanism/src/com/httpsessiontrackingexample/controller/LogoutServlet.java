package com.httpsessiontrackingexample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends 
HttpServlet{
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws IOException, ServletException{
HttpSession hs=req.getSession(false);
String status=null;
if(hs!=null){
hs.invalidate();	
status="You Are Loggedout Successfully";	
}else{
status=" Your Session Expired";	
}
PrintWriter pw=res.getWriter();
pw.println("<h3 align='center'>"+status+"</h3>");
String target="/loginForm.html";
RequestDispatcher rd=req.getRequestDispatcher(target);
rd.include(req,res);

	}

}
