package com.sgs.simple;

public class Student {
	
	 int id; 
	 String name;  
	 String address; 

	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student : [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	

	public static void main(String[] args) {
		
		   Student s1=new Student(100, "gaurav" ,"blr");  
		   Student s2=new Student(50, "kumar", "hyd");  
           
		   /* If you print any object, java compiler internally invokes the toString() method on the object.*/
		   /* If we want our own desired output then override toString() method.*/
		  /* toString method belongs from Object class so it is by default available in all the class. so we need to override this*/
		   
		   System.out.println(s1); /* We are printing object here.*/   //compiler writes here s1.toString()    
		   System.out.println(s2);/*  We are printing object here compiler invokes toString() method on the object, means s2.toString(). */ 

	}

}
