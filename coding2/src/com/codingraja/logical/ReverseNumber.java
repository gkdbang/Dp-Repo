package com.codingraja.logical;

import java.util.Scanner;

public class ReverseNumber {
	
	public static void main(String[] args) {
		
		int originalNumber = 0;
		int reverseNumber = 0;
		int temp = 0;
		
		System.out.println("Enter the Number You Want to Reverse : ");
		Scanner sc = new Scanner(System.in);
		originalNumber  = sc.nextInt();
		
		while(originalNumber!=0){
			temp = originalNumber%10;  // We know modulo gives us last digit of a number
			reverseNumber=reverseNumber*10+temp;
			originalNumber/=10;   // And We know divide reduce one digit from last
		}
		System.out.println("Reverse Number is : "+reverseNumber);
		sc.close();
	}
	
}
