package com.sgs.general;

public class Test{

	public static void main(String[] args){
	
	    System.out.println("from main method");
		methodA(); // Or else we can also write Test.methodA();
	}
	public static void methodA(){
	
		System.out.println("from static methodA() ==");
		Test t = new Test();
		t.methodB();
	}
	
	public void methodB(){
	
		System.out.println("from non-static methodB() ===");
		Test t = new Test();
		t.methodC();
	}
	
	public void methodC(){
	
		System.out.println("from non-static methodC() ===");
		methodD();  // From non-static method we can call to any non-static method without object reference.
	}
	
	public void methodD(){
		
		System.out.println("from non-static methodD() ===");
		methodE(); // Or else we can also use Test.methodE();
		Test.methodF();
	}
	
	public static void methodE(){
		
		System.out.println("from static methodE()=======");
	}
	
	public static void methodF(){
		
		System.out.println("from static methodF()=======");
	}
	
}
