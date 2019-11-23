package com.gaurav.ecom2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.ecom2.exceptions.CustomException;
import com.gaurav.ecom2.exceptions.CustomerNotFoundException;
import com.gaurav.ecom2.model.Customer;
import com.gaurav.ecom2.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="/addCustomer",consumes={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE},produces=MediaType.APPLICATION_JSON_VALUE)
	public Response addCustomer(@RequestBody List<Customer> customer){
		List<Customer> customers=new ArrayList<Customer>();	
		try {
			customers=customerService.addCustomer(customer);
			return Response.status(201).entity(customers).build();
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			return Response.status(500).entity(message).build();
		}
	}
	
	@GetMapping(value="/getAllCustomer",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getAllCustomer(){
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers=customerService.getAllCustomer();
			if(customers.size()>0){
				ResponseBuilder builder=Response.status(200).entity(customers);
				Response response=builder.build();
				return response;
			}
			else{
					return Response.ok("There is no record in database !").build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			ResponseBuilder builder=Response.status(500).entity(message);
			Response response=builder.build();
			return response;
		}
	}
	
	@GetMapping(value="/getOneCustomer/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getCustomerById(@PathVariable("id") Long id){
		Customer customer=new Customer();
		try {
			customer=customerService.getCustomerById(id);
			if(customer==null){
				throw new CustomerNotFoundException("No Employee Found with id :"+id);
			}
			else{
				ResponseBuilder builder=Response.status(200).entity(customer);
				Response response=builder.build();
				return response;
			}
		} 
		catch(CustomerNotFoundException e){
			throw new CustomerNotFoundException("No Employee Found with id :"+id);
		}
		catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			ResponseBuilder builder=Response.status(500).entity(message);
			Response response=builder.build();
			return response;
		}
	}
	
	@GetMapping(value="/getCustomerByEmail",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getCustomerByEmail(@RequestParam("email") String email){
		Customer customer=new Customer();
		try {
			customer=customerService.getCustomerByEmail(email);
			if(customer==null){
				throw new CustomException("No Employee Found with email : "+ email);
			}
			else{
				ResponseBuilder builder=Response.ok(customer).status(200);
				Response response=builder.build();
				return response;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("No Employee Found with email : "+ email);
		}
	}
	
	@GetMapping(value="/getCustomerByMobile/{mobileNo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getCustomerByMobile(@PathVariable("mobileNo") Long mobileNo){
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers=customerService.getCustomerByMobile(mobileNo);
			ResponseBuilder builder=Response.ok(customers).status(200);
			Response response=builder.build();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			ResponseBuilder builder=Response.ok(message).status(500);
			Response response=builder.build();
			return response;
		}
	}
	
	@GetMapping(value="/getCustomerByItemName/{itemName}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getCustomerByItemName(@PathVariable("itemName") String itemName){
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers=customerService.getCustomerByItemName(itemName);
			ResponseBuilder builder=Response.ok(customers).status(200);
			Response response=builder.build();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			ResponseBuilder builder=Response.ok(message).status(500);
			Response response=builder.build();
			return response;
		}
	}

	
	@GetMapping(value="/getCustomerByModelNo/{modelNo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getCustomerByModelNo(@PathVariable("modelNo") String modelNo){
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers=customerService.getCustomerByModelNo(modelNo);
			return Response.ok(customers).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			return Response.ok(message).status(500).build();
		}
	}
	
	@GetMapping(value="/getCustomerByBrand/{brand}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getCustomerByBrand(@PathVariable("brand") String brand){
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers=customerService.getCustomerByBrand(brand);
			return Response.ok(customers).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			return Response.ok(message).status(500).build();
		}
	}
	
	@PutMapping(value="/updateCustomer/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Response UpdateCustomer(@RequestBody Customer customer,@PathVariable("id") Long id){
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers=customerService.UpdateCustomer(customer, id);
			String message="Record Updated Successfully";
			return Response.status(200).entity(message +"\n"+customers).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity(new String("Record not updated successfully")).build();
		}
	}
	
	@DeleteMapping(value="/deleteOneCustomer/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response deleteCustomerById(@PathVariable("id") Long id){
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers=customerService.deleteCustomerById(id);
			String message="Record deleted Successfully";
			return Response.status(200).entity(message +"\n"+customers).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity(new String("Record not deleted successfully")).build();
		}
	}
	
	@DeleteMapping(value="/deleteAllCustomer")
	public Response deleteAllCustomer(){
		List<Customer> customers=new ArrayList<Customer>();
		try {
			customers=customerService.getAllCustomer();
			String message=null;
			if(customers.size()!=0){
				customerService.deleteAllCustomer();
				message="All Customer Record delete Successfully";
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
