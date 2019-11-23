package com.usermanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		String userEmail=req.getParameter("email");
		String userCountry=req.getParameter("country");
		// By Default EveryOne is normal User
		String userRole="USER";
		
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(userEmail);
		user.setCountry(userCountry);
		user.setUserRole(userRole);
	
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
		
		HttpSession httpSession=req.getSession(true);
		String userName=(String) httpSession.getAttribute("username");
		
		if(userName==null){
			try {
				req.setAttribute("loginMessage", "You need to do login first !! ");
				req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		else{
			int id=Integer.parseInt(req.getParameter("id"));
			//User user=userDao.getUser(id);
			String sessionRole=(String)httpSession.getAttribute("ROLE");
			
			if(("ADMIN".equalsIgnoreCase(sessionRole))){
				userDao.deleteUser(id);
				try {
					resp.sendRedirect("list");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				req.setAttribute("message", "You Are not allowed to delete this !! ");
				req.setAttribute("users", userDao.getAllUser());
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-list.jsp");
				try {
					requestDispatcher.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // end of else
		
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
		
			HttpSession httpSession=req.getSession(true);
			String userName=(String) httpSession.getAttribute("username");
			RequestDispatcher requestDispatcher=null;
			
			if(userName!=null){
				int id=Integer.parseInt(req.getParameter("id"));
				User existingUser=userDao.getUser(id);
				String sessionRole=(String)httpSession.getAttribute("ROLE");
				List<User> users=userDao.getAllUser();				
				System.out.println(existingUser);
				if(sessionRole.equalsIgnoreCase("ADMIN")){
					req.setAttribute("user", existingUser);
					requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/edit-userForm.jsp");
					try {
						System.out.println("Inside try block =========");
						requestDispatcher.forward(req, resp);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
				}
				else{
					req.setAttribute("message", "You Are not allowed to edit this !! ");
					req.setAttribute("users", users);
					requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/user-list.jsp");
					try {
						requestDispatcher.forward(req, resp);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} // end of if
			else{
				//System.out.println("else part");
				req.setAttribute("loginMessage", "You need to do login first !! ");
				requestDispatcher=req.getRequestDispatcher("WEB-INF/pages/login.jsp");
				try {
					requestDispatcher.forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			} // end of else
			

	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
			int id=Integer.parseInt(req.getParameter("id"));
			String userName=req.getParameter("userName");
			String userEmail=req.getParameter("email");
			String userCountry=req.getParameter("country");
			
			
			User user=new User();
			user.setId(id);
			user.setUserName(userName);
			user.setEmail(userEmail);
			user.setCountry(userCountry);
			
			userDao.updateUser(user);
			try {
				resp.sendRedirect("list");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
