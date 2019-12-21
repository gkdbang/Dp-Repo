//Program to Delete an Element from an Array.

package com.codingraja.array;

import java.util.Scanner;

 class ArrayDeleteElement {

	public static void main(String[] args) {
		
		int num, position;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++)
        {
            array[i] = s.nextInt();
        }
        
        System.out.print("Enter position of Element:");
        position = s.nextInt();
        
        
        for(int i=position-1; i<num-1; i++)
        {
            array[i] = array[i+1];
        }
     
        System.out.println("New Array is : ");
        for(int i=0 ; i<num-1; i++)
            System.out.print(array[i] + " ");
		
		s.close();
	}

}
