package com.quinnox.jsonbasedrestfulwebservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/order-inventory")
public class OrderService {
		
		@GET
		@Path("/order/{orderId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Order getOrderById(@PathParam("orderId") Integer orderId){
			
			Order order=new Order();
			order.setOrderId(orderId);
			order.setCustomer("Java2novice");
			order.setAddress("Bangalore");
			order.setAmount(1000);
			return order;
		}
}
