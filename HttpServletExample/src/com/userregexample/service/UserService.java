package com.userregexample.service;
import com.userregexample.domain.User;
import com.userregexample.factory.DAOFactory;
public class UserService {
 public String registerUser(User user) {
String status=
"registration is failure!Please Try Again."; 
int count=
DAOFactory.getUserDAO().registerUser(user);
	if(count>0){
	status="Registration successfully completed";
	}
	return status;
	}
}