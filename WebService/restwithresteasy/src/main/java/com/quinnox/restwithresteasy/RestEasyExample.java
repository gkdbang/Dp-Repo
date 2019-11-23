package com.quinnox.restwithresteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/publish")
public class RestEasyExample {
		
		@GET
		@Path("/{message}")
		public Response publishMessage(@PathParam("message") String message){
			String responseStr="Hello RestEasy Imlementation for "+message;
			return Response.status(200).entity(responseStr).build();
		}
	
}
