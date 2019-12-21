package com.codingraja.array;

import java.util.Scanner;

// Program to reverse of an  Array without taking two array

public class ArrayReverse3 {
	
	public static void main(String[] args) {
		
		int num,temp,i,j;
		
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = sc.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(i=0;i<array.length;i++)
        {
            array[i] = sc.nextInt();
        }
        
        for(i=array.length-1,j=0; j<=i; i--,j++){
        	temp=array[i];
        	array[i]=array[j];
        	array[j]=temp;
        }
     
        System.out.println("Reverse of Array:  ");
        for(i=0;i<array.length;i++)
        	System.out.print(array[i] + " ");
		sc.close();
	}
	
}
