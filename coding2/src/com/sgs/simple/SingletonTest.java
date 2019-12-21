package com.sgs.simple;

public class SingletonTest {
	
	public static void main(String[] args){
		
		Person p1 = Person.getInstance();
		System.out.println("First Person : "+p1);
		Person p2 = Person.getInstance();
		System.out.println("Second Person : "+p2);
		Person p3 = Person.getInstance();
		System.out.println("Third Person : "+p3);
		
		System.out.println("======================================");
		
		User user1 = User.getInstance();
		System.out.println("First User : "+user1);
		User user2 = User.getInstance();
		System.out.println("Second User : "+user2);
		User user3 = User.getInstance();
		System.out.println("Third User : "+user3);
		
	}
	
}
