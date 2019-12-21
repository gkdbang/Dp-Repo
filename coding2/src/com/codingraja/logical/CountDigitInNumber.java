package com.codingraja.logical;

import java.util.Scanner;

public class CountDigitInNumber {

	public static void main(String[] args) {
		
		long digit=0,count=0;
		
		System.out.println("Enter the number you want to count: ");
		Scanner sc = new Scanner(System.in);
		digit=sc.nextInt();
		// Logic
		while(digit!=0){
			++count;
			digit/=10;
		}
		System.out.println("The number of digits are : "+count);
		sc.close();
	}
}
