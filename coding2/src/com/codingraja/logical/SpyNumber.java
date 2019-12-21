package com.codingraja.logical;

import java.util.Scanner;

public class SpyNumber {

	public static void main(String[] args) {
		
		int num,temp,sum=0, product=1;
		
		System.out.println("Enter a number you want check : ");
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		
		// Logic to spy number
		while(num!=0){
			temp=num%10;  // Modulo operator gives us last digit of a number.
			sum+=temp;
			product*=temp;
			num/=10;       // Divide operator reduce one digit form last.
		}
		if(sum==product)
			System.out.println("Given number is a spy number");
		else
			System.out.println("Given number is not a spy number");
		sc.close();
	}
}
