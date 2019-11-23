package com.quinnox.jaxrshttpbasicauthclient.client;

import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.quinnox.jaxrshttpbasicauthclient.model.Order;

public class JerseyGetClient {

	public static void main(String[] args) {
		
		String baseUrl="http://localhost:8080/jaxrshttpbasicauth/order-inventory";
		
		String userName="Java2novice";
		String password="Simple4u!";
		String authString=userName+":"+password;
		
		// Now will encode the authString
		String authEncodedString=Base64.getEncoder().encodeToString(authString.getBytes());
		
		System.out.println(authEncodedString);
		
		Client client=ClientBuilder.newClient();
		WebTarget webTarget=client.target(baseUrl).path("order").path("10");
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header("authorization", "Basic " + authEncodedString);
		Response response=invocationBuilder.get();
		
		if(response.getStatus()!=200){
			System.out.println("Unable to connect to the server");
		}
		else{
			Order order=response.readEntity(Order.class);
			System.out.println("Status : "+ response.getStatus()+" : "+ response.getStatusInfo());
			System.out.println(order.toString());
		}
	
	}

}
