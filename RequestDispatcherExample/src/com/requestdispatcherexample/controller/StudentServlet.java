package com.requestdispatcherexample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.requestdispatcherexample.dao.StudentDAO;
import com.requestdispatcherexample.domain.Student;

public class StudentServlet extends HttpServlet{
	private StudentDAO studentDAO;
	public void init(){
		studentDAO=new StudentDAO();
	}
public void doPost(HttpServletRequest req,
		HttpServletResponse res)
				throws ServletException, IOException{
	//gather the Request Parameter i,e studentId
int sid=Integer.parseInt(req.getParameter("studentId"));
//call DAO method    
Student student=studentDAO.searchStudent(sid);
   //store the results(student obj) into the memory obj's(request obj/session obj/servletContext obj)
req.setAttribute("student",student);
//public void setAttribute(String attrName,Object attrValue)
//forward the request to target WebResource(servlet/jsp/html)
String target="/viewStudentServlet";
//create RequestDispatcher object
/* p RequestDispatcher getRequestDispatcher(String target);
*/
//use forward mechanism 
 RequestDispatcher rd=
		 req.getRequestDispatcher(target);
 rd.forward(req,res);
}
}
