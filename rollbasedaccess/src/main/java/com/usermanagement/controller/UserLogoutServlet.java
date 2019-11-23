package com.usermanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// it return the current session if present or else return returns null
		HttpSession oldSession=req.getSession(false);
		
		if(oldSession!=null){
			//oldSession.setAttribute("username",null);
			oldSession.removeAttribute("username");
			oldSession.invalidate();
			resp.sendRedirect("index.jsp");
		}
		else{
			resp.sendRedirect("index.jsp");
		}

	}
}
