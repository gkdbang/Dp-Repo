package com.gaurav.userphone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.userphone.model.User;
import com.gaurav.userphone.service.UserService;


@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE},produces=MediaType.APPLICATION_JSON_VALUE)
	public Response addUser(@RequestBody List<User> user){
		List<User> users= new ArrayList<User>();
		try {
			 users=userService.addUser(user);
			 return Response.ok().status(Status.CREATED).status(201).entity(users).build();
		} catch (Exception e) {
			 e.printStackTrace();
			 String exceptionMessage=e.getMessage(); 
			 return Response.ok().status(Status.EXPECTATION_FAILED).status(500).entity(exceptionMessage).build();
		}
	}
	
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getAllUser(){
		List<User> users=new ArrayList<User>();
		try {
			 users=userService.getAllUser();
			 return Response.ok().status(Status.FOUND).status(200).entity(users).build();
			 //return Response.ok(users).status(Status.FOUND).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage=e.getMessage();
			return Response.ok().status(Status.NOT_FOUND).status(500).entity(exceptionMessage).build();
		}
	}
	
	@RequestMapping(value="/getOneUser/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getUserById(@PathVariable("id") Integer id){
		User user=new User();
		try {
			user=userService.getUserById(id);
			return Response.ok().status(Status.FOUND).status(200).entity(user).build();
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage=e.getMessage();
			return Response.ok().status(Status.NOT_FOUND).status(500).entity(exceptionMessage).build();
		}
	}
	
	@RequestMapping(value="/getUserByEmail/{name}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getUserByName(@PathVariable("name") String name){
		List<User> users=new ArrayList<User>();
		try {
			users=userService.getUserByName(name);
			return Response.ok().status(Status.FOUND).status(200).entity(users).build();
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage=e.getMessage();
			return Response.ok().status(Status.NOT_FOUND).status(500).entity(exceptionMessage).build();
		}
	}
	
	@RequestMapping(value="/getUserByPhoneNumber/{phoneNumber}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
		List<User> users=new ArrayList<User>(); 
		try {
			 users=userService.getUserByPhoneNumber(phoneNumber);
			 return Response.ok().status(Status.FOUND).status(200).entity(users).build();
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage=e.getMessage();
			return Response.ok().status(Status.NOT_FOUND).status(500).entity(exceptionMessage).build();
		}
	}
	
	@RequestMapping(value="/getUserByPhoneType/{phoneType}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getUserByPhoneType(@PathVariable("phoneType") String phoneType){
		List<User> users=new ArrayList<User>();
		try {
			users = userService.getUserByPhoneType(phoneType);
			return Response.ok().status(Status.FOUND).status(200).entity(users).build();
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage=e.getMessage();
			return Response.ok().status(Status.NOT_FOUND).status(500).entity(exceptionMessage).build();
		}
	}
	
	@RequestMapping(value="/updateUser/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Response UpdateUser(@RequestBody User user,@PathVariable("id") Integer id){
		List<User> users=new ArrayList<User>();
		try {
			users=userService.UpdateUser(user, id);
			return Response.ok().status(Status.CREATED).status(201).entity(users).build();
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage=e.getMessage();
			return Response.ok().status(Status.EXPECTATION_FAILED).status(500).entity(exceptionMessage).build();
		}
	}
	
	@RequestMapping(value="/deleteOneUser/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response deleteUserById(@PathVariable("id") Integer id){
		List<User> users=new ArrayList<User>();
		try {
			users=userService.deleteUserById(id);
			return Response.ok().status(200).entity(users).build();
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage=e.getMessage();
			return Response.ok().status(Status.EXPECTATION_FAILED).status(500).entity(exceptionMessage).build();
		}
	}
	
	@RequestMapping(value="/deleteAllUser",method=RequestMethod.DELETE)
	public Response deleteAllUser(){
		List<User> users = new ArrayList<User>();
		String message=null;
		try {
			users = userService.getAllUser();
			if(users.size()==0){
				message="No record to delete !";
				return Response.ok().status(Status.NO_CONTENT).entity(message).build();
				
			}
			else{
				userService.deleteAllUser();
				message="All User Record delete Successfully";
				ResponseBuilder responseBuilder=Response.ok().status(200).entity(message);
				Response response=responseBuilder.build();
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage=e.getMessage();
			return Response.ok().status(Status.EXPECTATION_FAILED).status(500).entity(exceptionMessage).build();
		}

	}
	
}

