package com.codingraja.array;

import java.util.Scanner;

public class AdditionOfTwoArray {

	public static void main(String[] args) {
		
		int num1=0;
		int num2=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements in the first Array : ");
		num1 = sc.nextInt();
		int[] fArray = new int[num1];
		
		System.out.println("Enter the First Array Elements : ");
		for(int i=0;i<fArray.length;i++){
			fArray[i]=sc.nextInt();
		}
		
		System.out.println("Enter number of elements in the second Array : ");
		num2 = sc.nextInt();
		int[] sArray = new int[num2];
		
		System.out.println("Enter the Second Array Elements : ");
		for(int i=0; i<num2;i++){
			sArray[i]=sc.nextInt();
		}
		
		int finalArray[] = new int[num1+num2];
		
		// Start Adding
		// Firstly add first array into finalArray
		for(int i=0; i<fArray.length;i++){
			finalArray[i]=fArray[i];
		}
		 
		// Then Add secondArray into final Array
		for(int i=0,fArrayLength=fArray.length; i<sArray.length; i++,fArrayLength++){
			finalArray[fArrayLength]=sArray[i];
		}
		
		// Print that finalArray
		System.out.println("After Addition of Two Array =============== : ");
		for(int i:finalArray){
			System.out.println(i);
		}
		sc.close();
	}

}
