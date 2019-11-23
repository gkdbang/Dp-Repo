package com.quinnox.jaxrspathwithregexp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeService {
	
	@GET
	@Path("/Id/{empId : [0-9]+}")
	public Response getEmployeeById(@PathParam("empId") String empId){
		return Response.status(200).entity("Got employee with id : "+empId).build();
	}
	
	@GET
	@Path("/name/{empName : [a-zA-Z\\s]+}")
	public Response getEmployeeByName(@PathParam("empName") String empName){
		return Response.status(200).entity("Got employee with name :"+empName).build();
	}
			
}
