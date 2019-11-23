package com.quinnox.restwithjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/publish")
public class JerseyExample {
		
		@GET
		@Path("/{message}")
		public Response publishMessage(@PathParam("message") String message){
			String responseStr="Hello Jersey Implementation for : "+message;
			return Response.status(200).entity(responseStr).build();
		}
}
