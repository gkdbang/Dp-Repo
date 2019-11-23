package com.quinnox.jaxrsqueryparamdefaultvalue;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeService {
		
	@GET
	@Path("/query")
	public Response getEmployeeQuery(@QueryParam("department") String department,
									 @QueryParam("branch") String branch){
		String response="Query Parameter received, dept value is : "+department+ 
				" and branch value is : "+branch;
		return Response.status(200).entity(response).build();
	}
		
	@GET
	@Path("/defaultQuery")
	public Response getEmployeeDefaultQuery(@DefaultValue("account") @QueryParam("department") String department,
											@DefaultValue("bangalore") @QueryParam("branch") String branch){
		String response="Query Parameter received, dept value is : "+department+ 
				" and branch value is : "+branch;
		return Response.status(200).entity(response).build();
	}
	// Alternatively we can use @Context UriInfo to get query parameter.	
}
