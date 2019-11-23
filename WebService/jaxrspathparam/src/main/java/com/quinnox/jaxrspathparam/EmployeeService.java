package com.quinnox.jaxrspathparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeService {
		
		@GET
		@Path("{empId}")
		public Response getEmployeeById(@PathParam("empId") String empId){
			return Response.status(200).entity("Got employee with id :"+ empId).build();
		}
		
		@GET
		@Path("{branch}/{department}")
		public Response getEmployeeList(@PathParam("branch") String branch, 
				@PathParam("department") String department){
			String response= "Employee branch name is : "+branch+ ", and department is : "+department;
			return Response.status(200).entity(response).build();
		}
	
}
