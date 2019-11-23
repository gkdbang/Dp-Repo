package com.quinnox.jaxrsallhttpmethodclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.quinnox.jaxrsallhttpmethod.model.Employee;

public class JerseyPutClient {

	public static void main(String[] args) {
		
		Client client=ClientBuilder.newClient();
		WebTarget webTarget=client.target("http://localhost:8080/jaxrsallhttpmethod/employee")
				.path("updateEmp").path("14");
		
		Employee employee=new Employee();
		employee.setId(14);
		employee.setName("Jack Kumar");
		
		Builder invocationBuilder=webTarget.request("application/json");
		Response response= invocationBuilder.put(Entity.entity(employee, "application/json"));
		System.out.println(response.getStatus()+" === "+response.getStatusInfo());

	}

}
