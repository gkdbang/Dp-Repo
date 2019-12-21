//Program to add Odd index and Even index Elements of Array

package com.codingraja.array;

import java.util.Scanner;

 class OddIndexAndEvenIndex {

	public static void main(String[] args) {
		
		int num,  sumOdd=0,  sumEven=0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++)
        {
            array[i] = s.nextInt();
        }
		
        for(int i=0; i<num; i++)   //Addition of array elements
        {
            if(i%2!=0)
                sumEven+=array[i];
            else
                sumOdd+=array[i];
        }
     
        System.out.println("Addition of Odd Index:" + sumOdd);
        System.out.println("Addition of Even inex:" + sumEven);
        
        

	}

}
