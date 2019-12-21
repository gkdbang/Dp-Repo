package com.sgs.simple;

public class User {     // Early Instantiation
	
	private static User user = new User();     // private static variable
	
	private User() {
		// keep private constructor so no one allow to create subclass to this class.
	}
	
	public static User getInstance(){     // create factory method so that one can call this method.
		return user;
	}
}
