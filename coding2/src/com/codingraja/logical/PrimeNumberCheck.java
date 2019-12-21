package com.codingraja.logical;

import java.util.Scanner;

public class PrimeNumberCheck {

	public static void main(String[] args) {
		
		int i=0,count=0,num=0;
		System.out.println("Enter the number you want to check : ");
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		// Logic for prime number
		for(i=1;i<=num;i++){
			if(num%i==0){  // Modulo operator gives us reminder.
				count++;
			}
		}
		if(count==2) // Count will be exactly 2 because prime number will be divisible by 1 and itself. 
			System.out.println("The Given number is a Prime Number");
		else
			System.out.println("The Given number is a not Prime Number");
		sc.close();
	}
}
