package com.codingraja.logical;

import java.util.Scanner;

public class PrimeNumberPrint {

	public static void main(String[] args) {
		
		int i,j,num=0;
		System.out.println("Enter the number upto you want to print : ");
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
	
		// Logic to print prime number
		for(i=2;i<=num;i++){
			for(j=2;j<=i;j++){
				if(i%j==0){
					break;
				}
			} 
			if(i==j)
				System.out.println(i+" : is a prime number");
		}
		sc.close();
	}  
}
