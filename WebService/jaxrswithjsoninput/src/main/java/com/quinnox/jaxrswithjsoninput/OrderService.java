package com.quinnox.jaxrswithjsoninput;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/order-inventory")
public class OrderService {
		
		@POST
		@Path("/order")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response addOrder(Order order){
			System.out.println(order.getOrderId());
			System.out.println(order.getCustomer());
			System.out.println(order.getAddress());
			System.out.println(order.getAmount());
			return Response.status(200).entity(order).build();
		}
}
