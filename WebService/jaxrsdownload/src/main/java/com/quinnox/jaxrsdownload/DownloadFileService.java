package com.quinnox.jaxrsdownload;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.quinnox.jaxrsdownload.exception.MissingFileException;

@Path("file")
public class DownloadFileService {
		
		private static final String FOLDER_PATH ="C:\\Gaurav\\";
		
		@GET
		@Path("/download/{fileName}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response downloadFile(@PathParam("fileName") String fileName){
			
			String fullFilePath=FOLDER_PATH+fileName;
			File file = new File(fullFilePath);
		
			if(file.exists()==false){
				System.out.println("If=========================");
				throw new MissingFileException(fileName+" : does not exist on this server");
			}
			else{
				ResponseBuilder responseBuilder=Response.ok((Object)file);
				
				// Set “Content-Disposition” in Response header to tell 
				// browser pop up a download box for user to download.
				
				return responseBuilder.entity("FIle Successfully Downloaded")
						.header("content-disposition","attachment; filename = "+fileName)
						.build();
			}

		}
	
}
