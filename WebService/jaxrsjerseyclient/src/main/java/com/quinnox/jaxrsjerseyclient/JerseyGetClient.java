package com.quinnox.jaxrsjerseyclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyGetClient {
		
		public static void main(String[] args) {
			
			String baseUrl="http://localhost:8080/jsonbasedrestfulwebservice/order-inventory";
			Client client=Client.create();
			WebResource webResource=client.resource(baseUrl).path("order").path("102");
			ClientResponse clientResponse =  webResource.accept("application/json")
					.get(ClientResponse.class);
			
			if(clientResponse.getStatus()!=200){
				System.out.println("Unable to connect to the server : ");
			}
			String output=clientResponse.getEntity(String.class);
			System.out.println("Status : "+clientResponse.getStatus());
			System.out.println("Response : "+output);
		}
}
