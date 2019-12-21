package com.sgs.interview.logical;

import java.util.Scanner;

public class PermutaionAndCombination {
	
	
	public static void main(String[] args) {
		
		int n,r;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of n : ");
		n=sc.nextInt();
		System.out.print("Enter the number of r : ");
		r=sc.nextInt();
		
		long nPr=factorial(n)/(factorial(n-r));
		long nCr=factorial(n)/(factorial(n-r)*factorial(r));
		System.out.println("nPr is : "+nPr);
		System.out.println("nCr is : "+nCr);
		
		sc.close();
	}

	public static long factorial(int number) {
		int fact=1;
		for(int i=number;i>1;i--){
			fact=fact*i;
		}
		return fact;
	}
}
