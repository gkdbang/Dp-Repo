package com.quinnox.httprequestheaders.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/displayInHeaderServlet")
public class DisplayHeaderController extends HttpServlet{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//handleRequest(req, resp);
			handleRequest2(req,resp);
		}

		@SuppressWarnings("unchecked")
		private void handleRequest2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			// set the response content type
			resp.setContentType("text/html");
			
			System.out.println(req.getRequestURL());
			// Print the response
			PrintWriter writer = resp.getWriter();
			
			org.json.simple.JSONObject jsonObject=new org.json.simple.JSONObject();
			
			Enumeration<String> headerNames=req.getHeaderNames();
			while(headerNames.hasMoreElements()){
				String paramName=headerNames.nextElement();
				String paramValue=req.getHeader(paramName);
				jsonObject.put(paramName, paramValue);
			}
			
			writer.println(jsonObject);
		}

		private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			
			// set the response content type
			resp.setContentType("text/html");
			
			// Print the response
			PrintWriter writer = resp.getWriter();
			Map<String,String> map=new HashMap<>();
			
			Enumeration<String> headerNames=req.getHeaderNames();
			while(headerNames.hasMoreElements()){
				String paramName=headerNames.nextElement();
				String paramValue=req.getHeader(paramName);
				map.put(paramName, paramValue);
			}
			
			JSONObject jsonObject=new JSONObject(map);
			writer.write(jsonObject.toString());
		}
}
