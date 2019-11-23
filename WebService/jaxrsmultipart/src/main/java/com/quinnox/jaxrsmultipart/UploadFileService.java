package com.quinnox.jaxrsmultipart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/test")
public class UploadFileService {
		
		private static final String FOLDER_PATH="C:/Server/";
		@POST
		@Path("/upload")
		@Consumes(MediaType.MULTIPART_FORM_DATA)
		@Produces(MediaType.TEXT_PLAIN)
		public Response uploadFile(@FormDataParam("file") InputStream fis,
								   @FormDataParam("file") FormDataContentDisposition fdcc){
 // we are using @FormDataParam to received the uploaded file, InputStream to read the bytes from input streams
 // whether the stream is a file, a web page, or the screen shouldn't matter.
 // And FormDataContentDisposition to receive file properties like name, header, etc.

			OutputStream outputStream = null;
			String fileName = fdcc.getFileName();
			System.out.println(fileName);
			String filePath=FOLDER_PATH+fileName;
			
			int read=0;
			byte[] bytes=new byte[1024];
			try {
				outputStream = new FileOutputStream(new File(filePath));
				read=fis.read(bytes);
				while (read!=-1) {
					outputStream.write(bytes, 0, read);
				}
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new WebApplicationException("Error while uploading the file. "
						+ "please try again !!");
			}
			finally {
				if(outputStream!=null){
					try{outputStream.close();} catch(Exception ex){}
				}
			}
			System.out.println("File Uploaded Successfully");
			return Response.ok("File Uploaded Successfully").build();
		}
}
