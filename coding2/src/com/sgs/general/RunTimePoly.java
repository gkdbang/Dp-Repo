package com.sgs.general;

class Employee{
	public void develop(){
		System.out.println("Employee Can Develop");
	}
	public void test(){
		System.out.println("Employee Can Test");
	}
}
class Developer extends Employee{
	public void test(){
		System.out.println("Developer-Employee Can not Test");
	}
}

public class RunTimePoly {

	public static void main(String[] args) {
			
		Employee emp = new Employee();
		emp.test();   // Parent class test() method will execute.
		
		Developer dev = new Developer();
		dev.test();    // Child class test() method will execute.
		
		Employee emp1 = new Developer();
		emp1.test();   /*Compiler will just check test(); method is available inside Employee class or not. But
					   At run time JVM will execute test(); method from Developer class*/
	}				   

}
