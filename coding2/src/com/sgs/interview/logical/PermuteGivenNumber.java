package com.sgs.interview.logical;

import java.util.Scanner;

public class PermuteGivenNumber {

	public static void main(String[] args) {
		
		int n,r;
		String str=null;
		int countDigit=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number you want to permute : ");
		str=sc.next();
		
		// find out the length of string
		countDigit=str.length();
		// now countDigit automatically will become the n value
		n=countDigit;

		// give chance to user to enter r value
		System.out.print("Enter the r value : ");
		r=sc.nextInt();
		
		// calculate the possible combination by shuffling the number
		long nPr=factorial(n)/(factorial(n-r));
		System.out.println("The possible combinatations are : "+nPr);
		sc.close();
		
	}
	public static long factorial(int number){
		int fact=1;
		for(int i=number;i>1;i--){
			fact=fact*i;
		}
		return fact;	
	}
	
}
