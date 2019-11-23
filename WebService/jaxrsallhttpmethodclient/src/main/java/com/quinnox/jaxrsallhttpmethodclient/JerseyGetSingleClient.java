package com.quinnox.jaxrsallhttpmethodclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.quinnox.jaxrsallhttpmethod.model.Employee;

public class JerseyGetSingleClient {
		
	public static void main(String[] args) {
		Client client=ClientBuilder.newClient();
		WebTarget webTarget=client.target("http://localhost:8080/jaxrsallhttpmethod/employee")
				.path("getSingle").path("16");
		Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON);
		Response response= invocationBuilder.get();
		Employee employee=response.readEntity(Employee.class);
		System.out.println("Status : "+response.getStatus());
		System.out.println(employee.toString());
	}
}
