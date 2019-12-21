package com.codingraja.logical;

import java.util.Scanner;

public class FibonociiSeries {

	public static void main(String[] args) {
		
		int n1=0,n2=1,n3,num;
		
		System.out.println("Enter The number upto you want to print : ");
		Scanner sc=new Scanner(System.in);
		num = sc.nextInt();
		
		System.out.println("FibonociiSeries is : ");
		// First print initial values 0,1
		System.out.print(n1+" "+n2);
		
		for(int i=1; i<num-1; ++i){
			n3=n1+n2;
			System.out.print(" "+n3);
			n1=n2;
			n2=n3;
		}
		sc.close();
	}
}
