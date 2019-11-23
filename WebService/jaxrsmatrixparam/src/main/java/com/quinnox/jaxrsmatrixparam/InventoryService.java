package com.quinnox.jaxrsmatrixparam;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/inventory")
public class InventoryService {
		
		@GET
		@Path("{deviceType}")
		public Response getInventoryDetails(@PathParam("deviceType") String deviceType,
				@MatrixParam("company") String company, @MatrixParam("model") String model){
			String response="Received request for device : "+ deviceType + 
							", company is : "+ company+" and model is : "+model; 
			return Response.status(200).entity(response).build();
		}
	
}
