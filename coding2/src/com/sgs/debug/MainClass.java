package com.sgs.debug;

import java.util.Scanner;

public class MainClass {
	
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter First number");
			int num1 = sc.nextInt();
			System.out.println("Enter Second number");
			int num2 = sc.nextInt();
			
			// call to sum method
			int sum = DebugClass.sum(num1,num2);
			System.out.println("Sum : "+sum);
			
			// call to substraction method
			int sub = DebugClass.substraction(num1,num2);
			System.out.println("Sub : "+sub);
			
			// call to multiplication method
			int mul = DebugClass.mul(num1,num2);
			System.out.println("Multiply : "+mul);
			// call divide method
			
			int div = DebugClass.divide(num1,num2);
			System.out.println("Division : "+div);
			sc.close();		
		}
}
