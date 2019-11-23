package com.quinnox.jaxrsallhttpmethodclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class JerseyDeleteClient {

	public static void main(String[] args) {
		
		Client client=ClientBuilder.newClient();
		WebTarget webTarget=client.target("http://localhost:8080/jaxrsallhttpmethod/employee")
				.path("deleteemp").path("16");
		
		Builder invocationBuilder=webTarget.request();
		Response response= invocationBuilder.delete();
		System.out.println(response.getStatus()+" === "+response.getStatusInfo());

	}

}
