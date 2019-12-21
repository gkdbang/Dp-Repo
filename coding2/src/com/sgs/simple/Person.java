package com.sgs.simple;

public class Person {   // Lazy Instantiation
	
	private static Person p = null;    // private static variable
	
	private Person() {
		// keep private constructor so no one allow to create subclass to this class.
	}
	
	public static Person getInstance(){      // create factory method so that one can call this method. 
		if(p==null){
			p=new Person();
		}
		return p;
	}
	
}
