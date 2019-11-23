package com.quinnox.jaxrshttpbasicauth.service;

import java.util.Base64;
import java.util.StringTokenizer;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.quinnox.jaxrshttpbasicauth.model.Order;

@Path("/order-inventory")
public class OrderInventoryService {
		
		@GET
		@Path("/order/{orderId}")
		@Produces("application/json")
		public Response getUserById(@PathParam("orderId") Integer orderId,
								  @HeaderParam("authorization") String authEncodedString){
			if(authEncodedString!=null){
				System.out.println("Encoded Auth = "+authEncodedString);
				if(!isUserAuthenticated(authEncodedString)){
					return Response.status(401).entity("{\"error\":\"User not authenticated\"}").build();
				}
				Order order=new Order();
				order.setCustomerName("Java2Novice");
				order.setAddress("Bangalore");
				order.setAmount("$20000");
				return Response.status(200).entity(order).build();
			}
			else{
				String error="{\"error\":\"You are not authorised user\"}";
				return Response.status(401).entity(error).build();
			}
		}

		private boolean isUserAuthenticated(String authEncodedString) {
			
			String decodedAuth="";
			
			// Header will be in format of "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ"
			// We want the data only after Basic so we have to extract it.
			// we are splitting data based on space before decoding it back to original String
			
			String[] authParts=authEncodedString.split("\\s+");
			String authInfo=authParts[1];
			
			// Now decode the data back it to original String 
			byte[] bytes=null;
			bytes=Base64.getDecoder().decode(authInfo);
			decodedAuth=new String(bytes);
			System.out.println("Decoded Auth = "+decodedAuth);
			
			StringTokenizer stringTokenizer=new StringTokenizer(decodedAuth, ":");
			
			String userName=stringTokenizer.nextToken();
			String password=stringTokenizer.nextToken();
			
			// Custom Authentication logic
			if("Java2novice".equals(userName)&&"Simple4u!".equals(password)){
				return true;
			}
			return false;
		}
}
