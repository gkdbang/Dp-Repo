package com.codingraja.logical;

import java.util.Scanner;

public class CountFrequencyInteger {

	public static void main(String[] args) {
			
		int len=0,count=0;
		
		System.out.println("Enter the Number of Elements in Array : ");
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		Integer[] array = new Integer[len];
		
		System.out.println("Enter the element of an Array : ");
		for(int i=0;i<array.length;i++){
			array[i]=sc.nextInt();
		}
		
		// Logic
		for(int i=0;i<array.length;i++){
			count=1;
			for(int j=i+1;j<array.length;j++){
				if(array[i]==array[j] && array[i]!=null){
					count++;
					array[j]=null;
				}
			}
			if(array[i]!=null)
				System.out.println(array[i]+" is present "+count+" times");
		}	
		sc.close();
	}
}
