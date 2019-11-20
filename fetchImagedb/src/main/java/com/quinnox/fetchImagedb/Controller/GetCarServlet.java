package com.quinnox.fetchImagedb.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.fetchImagedb.dao.CarDao;
import com.quinnox.fetchImagedb.model.Car;

/**
 * Servlet implementation class GetCarServlet
 */

@WebServlet("/viewCar")
public class GetCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Inside Get");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String carName=request.getParameter("CarName");
		System.out.println("CarName : "+carName);
		CarDao carDao=new CarDao();
		
		try{
			Car car=carDao.getCar(carName.trim());
			request.setAttribute("car", car);
			String page="WEB-INF/view/viewCar.jsp";
			RequestDispatcher requestDispatcher=request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

}
