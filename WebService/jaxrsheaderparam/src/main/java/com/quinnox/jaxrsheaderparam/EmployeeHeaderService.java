package com.quinnox.jaxrsheaderparam;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/http-header")
public class EmployeeHeaderService {
		
	// How to Pass header parameter as a method input
		@GET
		@Path("/query")
		public Response queryHeaderInfo(@HeaderParam("Cache-Control") String ccControl,
										@HeaderParam("User-Agent")  String usAgent,
										@HeaderParam("content-type") String content,
										@HeaderParam("date") String date){
			String response="Received http headers are Cache Control :" + ccControl + 
							", and User agent : "+usAgent+", Content-type is : "+content+
							", Date : "+ date;
			return Response.status(200).entity(response).build();
		}
		
}
