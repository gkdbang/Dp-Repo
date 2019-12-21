//Program to add an Element in Array at specified location.

package com.codingraja.array;

import java.util.Scanner;

 class ArrayInsertElement {

	public static void main(String[] args) {
		
		int num, position, element;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = sc.nextInt();
        int array[] = new int[num+1];
        
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++)
        {
            array[i] = sc.nextInt();
        }
        
        System.out.print("Enter the position where you want to insert element:");
        position = sc.nextInt();
        System.out.print("Enter the element you want to insert:");
        element = sc.nextInt();
        
        for(int i=num; i>=position; i--)
        {
            array[i] = array[i-1];
        }
        array[position-1] = element;
     
        System.out.println("New Array is :");
        for(int i=0 ; i<=num; i++)
            System.out.print(array[i] + " ");
        sc.close();
	}

}
