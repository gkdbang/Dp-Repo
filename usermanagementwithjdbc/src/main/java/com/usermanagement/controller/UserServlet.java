package com.usermanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagementwithjdbc.dao.UserDao;
import com.usermanagementwithjdbc.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao=new UserDao();
	}
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionPath=req.getServletPath();
		switch(actionPath){
		case "/new":
			showNewForm(req,resp);
			break;
		case "/insert":
			insertUser(req,resp);
			break;
		case "/update":
			updateUser(req,resp);
			break;
		case "/edit":
			showEditForm(req,resp);
			break;
		case "/delete":
			deleteUser(req,resp);
			break;
		default:
			listUser(req,resp);
		}
	}
	
	private void showNewForm(HttpServletRequest req, HttpServletResponse resp) {
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-form.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void insertUser(HttpServletRequest req, HttpServletResponse resp) {
		String userName=req.getParameter("name");
		String userEmail=req.getParameter("email");
		String userCountry=req.getParameter("country");
		
		User user=new User();
		user.setName(userName);
		user.setEmail(userEmail);
		user.setCountry(userCountry);
	
		userDao.saveUser(user);
		
		try {
			resp.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void listUser(HttpServletRequest req, HttpServletResponse resp) {
		
		List<User> users=userDao.getAllUser();
		req.setAttribute("users", users);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-list.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
		int id=Integer.parseInt(req.getParameter("id"));
		userDao.deleteUser(id);
		try {
			resp.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
			int id=Integer.parseInt(req.getParameter("id"));
			User existingUser=userDao.getUser(id);
			req.setAttribute("user", existingUser);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/edit-userForm.jsp");
			try {
				requestDispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
			int id=Integer.parseInt(req.getParameter("id"));
			String userName=req.getParameter("name");
			String userEmail=req.getParameter("email");
			String userCountry=req.getParameter("country");
			
			User user=new User(id, userName, userEmail, userCountry);
			userDao.updateUser(user);
			try {
				resp.sendRedirect("list");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
