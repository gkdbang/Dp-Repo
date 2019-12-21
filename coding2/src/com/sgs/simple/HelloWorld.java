package com.sgs.simple;

public class HelloWorld {
	
	/*HelloWorld(){
		System.out.println("Hello again");
	}*/
	
	public  void  test(int i){
		System.out.println("Hello avi");
		System.out.println(i);
		test2();
	}
	
	

	public  void  test2(){
		System.out.println("Hello aman");
		
	}
	
	public static void main(String[] args){
		
		HelloWorld HW = new HelloWorld();
		int i=10;
		HW.test(i);
		System.out.println("Hello Tiwari");
	}
	HelloWorld(){
		System.out.println("Hello again");
	}

}
