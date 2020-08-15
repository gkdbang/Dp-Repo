package com.userregexample.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.userregexample.domain.User;
import com.userregexample.service.UserService;
public class UserServlet extends HttpServlet{
private UserService userService;
public void init(){
	userService=new UserService();
}
public void doPost(HttpServletRequest req,
		HttpServletResponse res )
		throws ServletException,IOException{
String name=req.getParameter("name");
String email=req.getParameter("email");
String mobile=req.getParameter("mobile");
User user=new User();
  user.setName(name);
  user.setEmail(email);
  user.setMobile(mobile);
String status=userService.registerUser(user);
  PrintWriter pw=res.getWriter();
  pw.println("<html><body><h2>");
  pw.println(status);
  pw.println("</h2></body></html>");
		}
}
