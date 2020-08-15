package com.requestdispatcherexample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.requestdispatcherexample.domain.Student;

public class ViewStudentServlet 
extends HttpServlet{
public void doPost(HttpServletRequest req,
		HttpServletResponse res)
				throws IOException, ServletException{
	PrintWriter out=res.getWriter();

	//get student object from Request object
Student std=(Student)req.getAttribute("student");
String target="/pages/searchStudent.html";
RequestDispatcher rd=req.getRequestDispatcher(target);	
rd.include(req,res);
//create table by using html
out.println("<html><body><table border='1'>");
out.println("<tr><th>StudentId</th><th>Name</th><th>Email</th><th>Mobile</th><th>Course</th></tr>");
if(std!=null){
out.println("<tr><td>"+std.getStudentId()+"</td>");
out.println("<td>"+std.getName()+"</td>");
out.println("<td>"+std.getEmail()+"</td>");
out.println("<td>"+std.getMobile()+"</td>");
out.println("<td>"+std.getCourse()+"</td></tr>");
}
else{
out.println("<tr><td colspan='5' align='center'>Student Not Found</td></tr>");	
}
out.println("</table></body></html>");
}
}

