//Program to reverse of an  Array with taking two array

package com.codingraja.array;

import java.util.Scanner;

 class ArrayReverse {

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
        
        for(int i=num-1; i>=0; i--)   //Reverse of array elements
            rArray[num-i-1]=array[i];
     
        System.out.println("Reverse of Array:  ");
        for(int i=0; i<num; i++)
        	System.out.print(rArray[i] + " ");
		s.close();
	}

}
