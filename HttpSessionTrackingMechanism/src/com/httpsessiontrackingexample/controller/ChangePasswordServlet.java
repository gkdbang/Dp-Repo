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

public class ChangePasswordServlet extends
HttpServlet{
	private UserDAO userDAO;
	public void init(){
ServletContext context=getServletContext();
userDAO=(UserDAO)context.getAttribute("userDAO");
	}
	
public void doGet(HttpServletRequest req,
		HttpServletResponse res) throws ServletException, IOException{
HttpSession hs=req.getSession(false);
PrintWriter pw=res.getWriter();
res.setContentType("text/html");
if(hs!=null){
String userName=(String)hs.getAttribute("userName");
pw.print("welcome, "+userName);
String target="/changePassword.html";	
RequestDispatcher rd=req.getRequestDispatcher(target);	
rd.include(req,res);
}
else{
String status="Session Expired";
pw.print("<h3 align='center'>"+status+"</h3>");
String target="/loginForm.html";
RequestDispatcher rd=req.getRequestDispatcher(target);
rd.include(req,res);
}

}//end of doGet() method
public void doPost(HttpServletRequest req,
		HttpServletResponse res)throws ServletException,IOException{
HttpSession hs=req.getSession(false);
PrintWriter pw=res.getWriter();
res.setContentType("text/html");
  if(hs!=null){
	  String oldPassword=req.getParameter("oldpassword");
	  String newPassword=req.getParameter("newpassword");
 String userName=(String)hs.getAttribute("userName");
 String status="Dear "+userName+"Password Change Operation is Failure!Please Try Again";

 int count=userDAO.changePassword(userName,oldPassword,newPassword);
   if(count>0){
status="Dear "+userName+" Password Changed Successfully";	   
   }
 String target="menus.html";  
RequestDispatcher rd=req.getRequestDispatcher(target); 
    rd.include(req,res);
  pw.println(status);  
  }else{
	  String status="Session Expired";
	  pw.print("<h3 align='center'>"+status+"</h3>");
	  String target="/loginForm.html";
	  RequestDispatcher rd=req.getRequestDispatcher(target);
	  rd.include(req,res);
  }
}
}
