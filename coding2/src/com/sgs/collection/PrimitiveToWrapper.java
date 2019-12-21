package com.sgs.collection;

public class PrimitiveToWrapper {
	
	public static void main(String[] args) {
		
		char ch = 'a';
		//1st way to convert a primitive into object is pass that primitive inside constructor. 
		Character c = new Character(ch);
		System.out. println("Wrapper Object : "+c);
		
		//2nd Way convert a primitive into object is call static method valueOf.
		Character c2 = Character.valueOf(ch);
		System.out.println("Printing Wrapper Object From ValueOf Method : "+c2);
		
		// And what if Again we want that Primitive from wrapper object
		char ch2 = c2.charValue(); // un-boxing
		System.out.println("Again Primitive : "+ch2);
		
		System.out.println("================================================================");
		
		int i = 10;  
		// In the below line primitive int type i converting into an Object.
		// Storing Primitive inside an object is nothing but Boxing operation.
		Integer obj = new Integer(i);  // Boxing
		System.out. println("Wrapper Object : "+obj);
		
		
		// But here in the below line getting a primitive content from Object is Un-boxing.
		// Retrieving primitive int value from Integer Object.
		int k = obj.intValue(); //un-boxing
		System.out.println("Again Primitive : "+k);
		
		
		// Also From valueOf method we can get wrapper Object.
		Integer it = Integer.valueOf(i); // Boxing
		System.out.println("Printing Wrapper Object from valueOf method : "+it);
	}
		
}
