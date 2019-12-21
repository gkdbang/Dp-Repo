package com.codingraja.logical;

import java.util.Scanner;

public class CountFrequencyString {

	public static void main(String[] args) {
		
		int num=0,count=0;
		
		System.out.println("Enter the Number of Elements in Array : ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		String[] str = new String[num];
		
		System.out.println("Enter the element of an Array : ");
		for(int i=0;i<str.length;i++){
			str[i]=sc.next();
		}
		
		// Logic
		for(int i=0;i<str.length;i++){
			count=1;
			for(int j=i+1;j<str.length;j++){
				if(str[i].equals(str[j]) && str[i]!=""){
					count++;
					str[j]="";
				}
			}
			if(str[i]!="")
				System.out.println(str[i]+" is present "+count+" times");
		}	
		sc.close();
	}
}
