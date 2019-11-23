package com.quinnox.jaxrsallhttpmethodclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.quinnox.jaxrsallhttpmethod.model.Employee;

public class JerseyPostClient {

	public static void main(String[] args) {
		
		Client client=ClientBuilder.newClient();
		WebTarget webTarget=client.target("http://localhost:8080/jaxrsallhttpmethod/employee")
				.path("addEmployee");
		
		Employee employee=new Employee();
		employee.setId(14);
		employee.setName("Jack");
		
		Employee[] employees={employee};
		
		Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON);
		Response response= invocationBuilder.post(Entity.entity(employees, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus()+" === "+response.getStatusInfo());
		
	}

}
