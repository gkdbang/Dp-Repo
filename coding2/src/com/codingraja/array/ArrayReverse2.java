package com.codingraja.array;

import java.util.Scanner;

public class ArrayReverse2 {
		
	public static void main(String[] args) {
		
		int num;
		
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        int rArray[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++)
        {
            array[i] = s.nextInt();
        }
        
        for(int i=num-1,j=0; i>=0; i--,j++)   //Reverse of array elements
            rArray[j]=array[i];
     
        System.out.println("Reverse of Array:  ");
        for(int i=0; i<num; i++)
        	System.out.print(rArray[i] + " ");
		s.close();
	}
}
