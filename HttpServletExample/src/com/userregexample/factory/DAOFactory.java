package com.userregexample.factory;
import com.userregexample.dao.UserDAO;
public class DAOFactory {
private static UserDAO userDAO;
static{
userDAO=new UserDAO();
}
public static UserDAO getUserDAO(){
	return userDAO;
}
}
