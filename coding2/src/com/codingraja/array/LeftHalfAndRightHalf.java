//Program to add left half and right half of Array Elements

package com.codingraja.array;

import java.util.Scanner;

 class LeftHalfAndRightHalf {

	public static void main(String[] args) {
		
		int num,  sumLeft=0,  sumRight=0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++)
        {
            array[i] = s.nextInt();
        }
		
      //Addition of array elements
        for(int i=0; i<num; i++)  
        {
            if(i<=num/2)
                sumLeft+=array[i];
            else
                sumRight+=array[i];
        }
     
        System.out.println("Addition of Left Half:" + sumLeft);
        System.out.println("Addition of Right Half:"+ sumRight);
        
        

	}

}
