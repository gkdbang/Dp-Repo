package com.gaurav.userphone.service;

import java.util.List;

import com.gaurav.userphone.model.User;

public interface UserService {
	
	public List<User> addUser(List<User> User) throws Exception;
	public List<User> getAllUser() throws Exception;
	public User getUserById(Integer id) throws Exception;
	public List<User> getUserByName(String name) throws Exception;
	public List<User> getUserByPhoneNumber(String phoneNumber) throws Exception;
	public List<User> getUserByPhoneType(String phoneType) throws Exception;
	public List<User> UpdateUser(User User,Integer id) throws Exception;
	public List<User> deleteUserById(Integer id) throws Exception;
	public List<User> deleteAllUser() throws Exception;
}
