package com.quinnox.jaxrsjerseyclient;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyPostClient {
		
		public static void main(String[] args) {
			
			String baseUrl="http://localhost:8080/jaxrswithjsoninput/order-inventory";
			
			String inputJson="{\"customer\":\"Java2novice\", \"order-Id\": 1001,\"address\":\"Bangalore\","+
                "\"bill-amount\":\"2000\"}";

			Client client=Client.create();
			WebResource webResource = client.resource(baseUrl).path("order");
			ClientResponse clientResponse=webResource.type(MediaType.APPLICATION_JSON)
												.post(ClientResponse.class, inputJson);
			if(clientResponse.getStatus()!=200){
				System.out.println("Unable to connect to the server : ");
			}
			String output=clientResponse.getEntity(String.class);
			
			System.out.println("Status : "+clientResponse.getStatus());
			System.out.println("Response : "+output);
		}
		
}
