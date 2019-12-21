//Program to find addition of Array Elements

package com.codingraja.array;

import java.util.Scanner;

 class ArrayAddEachElement {

	public static void main(String[] args) {
		
		int num,  sum=0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++)
        {
            array[i] = s.nextInt();
        }
		
/*        for(int i=0; i<num; i++)   //Addition of array elements
            sum+=array[i];*/
        
        
        for(int i : array)     // We can also go through forEach loop
        	sum = sum+i;
        System.out.println("Addition of Array Elements :" + sum);
        s.close();
	}

}
