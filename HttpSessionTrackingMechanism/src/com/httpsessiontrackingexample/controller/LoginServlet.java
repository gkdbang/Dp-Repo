package com.httpsessiontrackingexample.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.httpsessiontrackingexample.dao.UserDAO;
public class LoginServlet 
extends HttpServlet{
	private UserDAO userDAO;
	public void init(){
		userDAO=new UserDAO();
		//add userDAO as an attribute to
		//servletContext obj
	ServletContext context=getServletContext();
	context.setAttribute("userDAO",userDAO);
	}
public void doPost(HttpServletRequest req,
		HttpServletResponse res)throws
		ServletException,IOException{
PrintWriter pw=res.getWriter();	
	//gather the request-parameters
String userName=req.getParameter("username");
String password=req.getParameter("password");
//communicate with DAO
 Integer userId=userDAO.login(userName, password);
 
 if(userId!=null && userId>0){ 
 //results(userName,userId)
	//store session (memory obj)
 HttpSession hs=req.getSession();
 System.out.println(hs.getId());
 hs.setAttribute("userId",userId);
 hs.setAttribute("userName",userName);
 String target="/welcomeServlet";
 RequestDispatcher rd=req.getRequestDispatcher(target);
 rd.forward(req,res);
 }
 else{
String target="/loginForm.html";
RequestDispatcher rd=req.getRequestDispatcher(target);
rd.include(req,res);
pw.print("<h3 align='center'>Your Login is Failure!Please Try Again</h3>");
 }
	
}
}
