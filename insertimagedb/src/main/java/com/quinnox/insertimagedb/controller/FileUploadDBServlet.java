package com.quinnox.insertimagedb.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.quinnox.insertimagedb.dao.FileUploadDao;

@WebServlet(urlPatterns = {"/", "/uploadFile"})
@MultipartConfig(maxFileSize=16177215)  // upload file size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FileUploadDBServlet() {
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Inside Get : ");
		request.getRequestDispatcher("WEB-INF/views/upload.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post : ");
		
		// gets values of text fields
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		
		// gets values of binary field as a part in this multipart request
		Part filePart=request.getPart("photo");
		
		InputStream inputStream=null;
		
		if(filePart!=null){
			// prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            
         // obtains input stream of the upload file
            inputStream=filePart.getInputStream();
		}
		
		
		FileUploadDao fileUploadDao=new FileUploadDao();
		Boolean status=fileUploadDao.saveFileToDB(firstName,lastName,inputStream);
		
		String message=null;
		String destination="WEB-INF/views/message.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(destination);
		if(status){
			message="File uploaded and saved into database";
			request.setAttribute("Message", message);
			requestDispatcher.forward(request, response);
		}
		else{
			message="Somthing went wrong ! ";
			request.setAttribute("Message", message);
			requestDispatcher.forward(request, response);
		}
		
	}

}
