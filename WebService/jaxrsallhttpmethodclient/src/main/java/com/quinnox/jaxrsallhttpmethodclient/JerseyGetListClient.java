package com.quinnox.jaxrsallhttpmethodclient;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.quinnox.jaxrsallhttpmethod.model.Employee;

public class JerseyGetListClient {

	public static void main(String[] args) {
		
		Client client=ClientBuilder.newClient();
		WebTarget webTarget=client.target("http://localhost:8080/jaxrsallhttpmethod/employee").path("getAll");
		Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON);
		Response response= invocationBuilder.get();
		Employee[] employee=response.readEntity(Employee[].class);
		System.out.println("Status : "+response.getStatus());
		for (Employee employee2 : employee) {
				System.out.println(employee2);
		}
		
		List<Employee> employees=Arrays.asList(employee);
		System.out.println(employees);
	}

}
