package com.quinnox.fileUpload.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns={"/", "/fileUpload"})
@MultipartConfig
public class FIleUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FIleUploadServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/upload.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileSavePath="E:\\Image\\New folder";
		
		Part filePart=request.getPart("file");
		if(filePart!=null){
			String fileName=extractFileName(filePart);
			filePart.write(fileSavePath+File.separator+fileName);
		}
		request.setAttribute("message", "Upload has been done successfully!");
		request.getRequestDispatcher("WEB-INF/views/message.jsp").forward(request, response);
	}
	
	private String extractFileName(Part filePart){
		Collection<String>headerList=filePart.getHeaderNames();
		System.out.println(headerList);
		String contentDiso=filePart.getHeader("content-disposition");
		System.out.println(contentDiso);
		String contentType=filePart.getHeader("content-type");
		System.out.println(contentType);
		String[] items=contentDiso.split(";");
		for (String str : items) {
			if(str.trim().startsWith("filename")){
				return str.substring((str.indexOf("=")+2),(str.length()-1));
			}
		}
		return "";		
	}
}
