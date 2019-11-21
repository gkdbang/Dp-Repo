package com.quinnox.insertmultipleimagedb.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.quinnox.insertmultipleimagedb.dao.FileUploadDao;

@WebServlet(urlPatterns = {"/", "/uploadFile"})
@MultipartConfig(maxFileSize=16177215,
				 maxRequestSize=1024*1024*50)  // 50 MB
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
		
		// gets values of binary fields as a collection of part in this multipart request
		Collection<Part> filePartlist=request.getParts();
		
		InputStream inputStream=null;
		FileUploadDao fileUploadDao=new FileUploadDao();
		Boolean status=null;
		
		for (Part filePart : filePartlist) {
			if(filePart!=null){
				// prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	            
	         // obtains input stream of the upload file
	            inputStream=filePart.getInputStream();
	            status=fileUploadDao.saveFileToDB(inputStream);
			}

		}
		
		String message=null;
		String destination="WEB-INF/views/message.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(destination);
		if(status){
			message="All Files have been uploaded and saved into database successfully";
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
