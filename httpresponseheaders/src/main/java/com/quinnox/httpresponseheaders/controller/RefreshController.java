package com.quinnox.httpresponseheaders.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class RefreshController
 */

@WebServlet("/refreshServlet")
public class RefreshController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		handleRequest(request,response);
		//doPost(request, response);
	}

	
	
	
	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		// Setting auto refresh in 15 second
		response.setIntHeader("Refresh", 15);
		
		// Get current time
		Calendar calendar = new GregorianCalendar();
		String time;
		if(calendar.get(Calendar.AM_PM)==0){
			time=calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND)+" "+"A.M.";
		}
		else{
			time=calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND)+" "+"P.M.";
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Current Time Is : ", time);
		response.getWriter().write(jsonObject.toString());
		//response.getWriter().println(jsonObject);
		//response.getWriter().write(time);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
