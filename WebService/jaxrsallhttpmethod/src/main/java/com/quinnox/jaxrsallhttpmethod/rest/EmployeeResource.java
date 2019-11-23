package com.quinnox.jaxrsallhttpmethod.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.quinnox.jaxrsallhttpmethod.model.Employee;

@Path("/employee")
public class EmployeeResource {
		
	
		private static List<Employee> employess=new ArrayList<Employee>(Arrays.asList(
		new Employee(11, "Lokesh"),
		new Employee(12, "Alex"),
		new Employee(13, "David")));
		

		 @GET
		 @Path("/getAll")
		 @Produces(MediaType.APPLICATION_JSON)
		 public List<Employee> getAllEmployees(){
			 return employess;	
		 }
		 
		 @GET
		 @Path("getSingle/{id}")
		 @Produces(MediaType.APPLICATION_JSON)
		 public Employee getEmployeeById(@PathParam("id") Integer id){
			
			  Employee singleEmployee=new Employee();
					for (Iterator<Employee> iterator = employess.iterator(); iterator.hasNext();) {
							Employee employee =  iterator.next();
							if(employee.getId()==id){
								singleEmployee=employee;
							}
							
						}
			 return singleEmployee; 
		 }
		 
		 @POST
		 @Path("/addEmployee")
		 @Consumes(MediaType.APPLICATION_JSON)
		 @Produces("application/json")
		 public Response addEmployee(List<Employee> addEmployees){
			 for (Employee employee : addEmployees) {
				 		employess.add(employee);
			 	  }
			 //employess.addAll(addEmployees);
			 return Response.status(200).entity(employess).build();
		 }
		 
		 @PUT
		 @Path("/updateEmp/{id}")
		 @Consumes(MediaType.APPLICATION_JSON)
		 @Produces("application/json")
		 public List<Employee> updateEmployeeById(@PathParam("id") Integer id, Employee updateEmp){
				for(int i=0; i<employess.size();i++) {
						Employee employee=employess.get(i);
						if(employee.getId()==id){
							employess.set(i, updateEmp);
						}	
				}
				return employess; 
			
		 }
		 
		 @DELETE
		 @Path("/deleteemp/{id}")
		 @Produces(MediaType.TEXT_PLAIN)
		 public Response deleteEmployeeById(@PathParam("id") Integer id){
				Employee deleteSingleEmp=new Employee();
				for(int i=0;i<employess.size();i++){
					deleteSingleEmp=employess.get(i);
					if(deleteSingleEmp.getId()==id){
						employess.remove(i);
					}
				}
			return Response.status(202).entity("Employee deleted successfully for the given !!"+id)
					.build();	 
		 }
		 
		 @DELETE
		 @Path("/deleteallemp")
		 @Produces("text/plain")
		 public Response deleteAllEmployee(){
			 
			 if(employess.size()>0){
				 employess.removeAll(employess);
				 return Response.status(202).entity("All employee delete successfully !").build(); 
			 }
			 return Response.status(201).entity("All employee delete already or no employee exist !")
					 .build();
		 }
		 
}
