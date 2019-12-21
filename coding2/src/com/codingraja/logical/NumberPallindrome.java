package com.codingraja.logical;

import java.util.Scanner;

public class NumberPallindrome {
	
	public static void main(String[] args) {
		
		int originalNumber = 0;
		int reverseNumber = 0;
		int temp = 0;
		
		System.out.println("Enter the Number You Want to check : ");
		Scanner sc = new Scanner(System.in);
		originalNumber  = sc.nextInt();
		int tempNumber = originalNumber;
		
		while(tempNumber!=0){
			temp = tempNumber%10;  // We know modulo gives us last digit of a number
			reverseNumber=reverseNumber*10+temp;
			tempNumber=tempNumber/10;   // And We know divide reduce one digit from last
		}
		if(originalNumber==reverseNumber)
			System.out.println("The given Number is Pallindrome");
		else
			System.out.println("The given Number is Not Pallindrome");
		sc.close();
	}
	
}
