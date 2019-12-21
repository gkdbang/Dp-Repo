package com.codingraja.logical;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		int factorial=1,num;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number you want to calculate factorial : ");
		num=sc.nextInt();
		
		for(int i=num;i>1;--i){
			factorial=factorial*i;
		}
		System.out.println("Factorial of a numer is : "+factorial);
		sc.close();
	}
}
