package com.quinnox.jaxrspathwithjersy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageService {
		
		@GET
		public Response pimgMe(){
			String defaultResonse="Hi ... how are you ? ";
			return Response.status(200).entity(defaultResonse).build();
		}
		
		// Simple URI
		@GET
		@Path("/birthday")
		public Response printBirthdayMessage(){
			String bDayResponse="Happy Birthday";
			return Response.status(200).entity(bDayResponse).build();
		}
		
		// Dynamic URI
		@GET
		@Path("/birthday/{custMessage}")
		public Response printCustomMessage(@PathParam("custMessage") String custMessage){
			String customResponse="Happy Birthday ... Many many happy returns of the day : "+custMessage;
			return Response.status(200).entity(customResponse).build();
		}
		
}
