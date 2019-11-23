package com.quinnox.jaxrscontexturiinfo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/employee")
public class EmployeeService {
		
		// Read multiple values from QueryParameter empdetails?id=1016&id=1017&id=1415
		@GET
		@Path("empdetails")
		public Response getEmployeeDetails(@Context UriInfo uriInfo){
			
			 /** read first employee id from request query parameter **/
			
			String firstName=uriInfo.getQueryParameters().getFirst("id");
			System.out.println("First Id from the request : "+firstName);
			
			/* read complete employee Id List from request query parameter */
			
			List<String> empIdList=uriInfo.getQueryParameters().get("id");
			System.out.println("Received all list : "+empIdList);
			
			return Response.status(200).entity("Processed Request").build();
		}
		
}
