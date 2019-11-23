package com.gaurav.ecom.customer.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.ecom.customer.model.Customer;
import com.gaurav.ecom.customer.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE},produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> addCustomer(@RequestBody List<Customer> customer){
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping(value="/getAllCustomer",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@RequestMapping(value="/getOneCustomer/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerById(@PathVariable("id") Long id){
		return customerService.getCustomerById(id);
	}
	
	@RequestMapping(value="/getCustomerByEmail/{email}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerByEmail(@PathVariable("email") String email){
		return customerService.getCustomerByEmail(email);
	}
	
	@RequestMapping(value="/getCustomerByMobile/{mobileNo}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomerByMobile(@PathVariable("mobileNo") Long mobileNo){
		return customerService.getCustomerByMobile(mobileNo);
	}
	
	@RequestMapping(value="/getCustomerByCity/{city}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomerByCity(@PathVariable("city") String city){
		return customerService.getCustomerByCity(city);
	}
	
	@RequestMapping(value="/getCustomerByState/{state}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomerByState(@PathVariable("state") String state){
		return customerService.getCustomerByState(state);
	}
	
	@RequestMapping(value="/getCustomerByZipcode/{zipcode}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomerByZipcode(@PathVariable("zipcode") Long zipcode){
		return customerService.getCustomerByZipcode(zipcode);
	}
	
	@RequestMapping(value="/getCustomerByHouseNo/{houseNo}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomerByHouseNo(@PathVariable("houseNo") String houseNo){
		return customerService.getCustomerByHouseNo(houseNo);
	}
	
	@RequestMapping(value="/updateCustomer/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> UpdateCustomer(@RequestBody Customer customer,@PathVariable("id") Long id){
		return customerService.UpdateCustomer(customer, id);
	}
	
	@RequestMapping(value="/deleteOneCustomer/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> deleteCustomerById(@PathVariable("id") Long id){
		return customerService.deleteCustomerById(id);
	}
	
	@RequestMapping(value="/deleteAllCustomer",method=RequestMethod.DELETE)
	public Response deleteAllCustomer(){
		
		List<Customer> customers=customerService.deleteAllCustomer();
		String message=null;
		if(customers.size()==0){
			message="All Customer Record delete Successfully";
			ResponseBuilder responseBuilder=Response.ok().entity(message);
			Response response=responseBuilder.build();
			return response;
		}
		else{
			message="Somthing went wrong !";
			return Response.ok().entity(message).build();
		}

	}
	
}
