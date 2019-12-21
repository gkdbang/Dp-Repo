package com.codingraja.logical;

import java.util.Scanner;

public class AddDigitOfNumber {

	public static void main(String[] args) {
		
		int number = 0;
		int addDigit = 0;
		int temp = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number : ");
		number = sc.nextInt();
		
		while (number!=0) {
			temp=number%10;   // Modulo gives us last digit of a number
			addDigit=addDigit+temp;
			number=number/10;   // divide reduce one digit from last 
		}
		System.out.println("Addition of each digit of the given number : "+addDigit);
		sc.close();
	}
}
