package com.gaurav.ecom2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.ecom2.exceptions.CustomException;
import com.gaurav.ecom2.model.Order;
import com.gaurav.ecom2.service.OrderService;

@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value="/getAllOrder", method=RequestMethod.GET, produces="application/json")
	public List<Order> getAllOrder(){
		List<Order> orders = new ArrayList<Order>();
		try{
			orders=orderService.getAllOrders();
			if(orders.size()>0){
					return orders;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return orders;
	}
	
	@GetMapping(value="/getOrderById/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getOrderByItemName(@PathVariable("id") Long id){
		Order order=new Order();
		try {
			order=orderService.getOrderById(id);
			if(order==null){
				throw new CustomException("No Order Found with id : "+ id);
			}
			else{
				return Response.ok(order).status(200).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("No Order Found with id : "+ id);
		}
	}

	
	@GetMapping(value="/getOrderByItemName/{itemName}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getOrderByItemName(@PathVariable("itemName") String itemName){
		List<Order> orders=new ArrayList<Order>();
		try {
			orders=orderService.getOrderByItemName(itemName);
			return Response.ok(orders).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			return Response.ok(message).status(500).build();
		}
	}
	
	@GetMapping(value="/getOrderByModelNo/{modelNo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getOrderByModelNo(@PathVariable("modelNo") String modelNo){
		List<Order> orders=new ArrayList<Order>();
		try {
			orders=orderService.getOrderByModelNo(modelNo);
			return Response.ok(orders).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			return Response.ok(message).status(500).build();
		}
	}
	
	@GetMapping(value="/getOrderByBrand/{brand}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getOrderByBrand(@PathVariable("brand") String brand){
		List<Order> orders=new ArrayList<Order>();
		try {
			orders=orderService.getOrderByBrand(brand);
			return Response.ok(orders).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			return Response.ok(message).status(500).build();
		}
	}
	
	@RequestMapping(value="/getOrderByFirstName/{firstName}", method=RequestMethod.GET, produces="application/json")
	public List<Order> getOrderByFirstName(@PathVariable("firstName") String firstName){
		List<Order> orders=new ArrayList<Order>();
		try{
			orders=orderService.getOrderByFirstName(firstName);
			return orders;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return orders;	
	}
	
	@RequestMapping(value="/getOrderByEmail", method=RequestMethod.GET, produces="application/json")
	public List<Order> getOrderByEmail(@RequestParam(value="email") String email){
		List<Order> orders=new ArrayList<Order>();
		try{
			orders=orderService.getOrderByEmail(email);
			if(orders.isEmpty()){
				throw new CustomException("No Order Found with email : "+ email);		
			}
			else{
				return orders;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new CustomException("No Order Found with email : "+ email);
		}	
	}
	
	@RequestMapping(value="/getOrderByMobileNo/{mobileNo}", method=RequestMethod.GET, produces="application/json")
	public List<Order> getOrderByMobileNo(@PathVariable("mobileNo") Long mobileNo){
		List<Order> orders=new ArrayList<Order>();
		try{
			orders=orderService.getOrderByMobileNo(mobileNo);
			return orders;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return orders;	
	}
	
	@PutMapping(value="/updateOrder/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Response UpdateOrder(@RequestBody Order order,@PathVariable("id") Long id){
		List<Order> orders=new ArrayList<Order>();
		try {
			orders=orderService.UpdateOrder(order, id);
			String message="Record Updated Successfully";
			return Response.status(200).entity(message +"\n"+orders).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity(new String("Record not updated successfully")).build();
		}
	}
	
	@DeleteMapping(value="/deleteOneOrder/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response deleteOrderById(@PathVariable("id") Long id){
		List<Order> orders=new ArrayList<Order>();
		try {
			orders=orderService.deleteCustomerById(id);
			String message="Record deleted Successfully";
			return Response.status(200).entity(message +"\n"+orders).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity(new String("Record not deleted successfully")).build();
		}
	}
	
	@DeleteMapping(value="/deleteAllOrder")
	public Response deleteAllOrder(){
		List<Order> orders=new ArrayList<Order>();
		try {
			orders=orderService.getAllOrders();
			String message=null;
			if(orders.size()!=0){
				orderService.deleteAllOrders();
				message="All Order Record delete Successfully";
				return Response.ok(message).build();
			}
			else{
				message="No record to delete !";
				return Response.status(Status.ACCEPTED).entity(message).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			return Response.status(500).entity(message +"\n"+ new String("Record not deleted successfully")).build();
		}

	}
	
	
}
