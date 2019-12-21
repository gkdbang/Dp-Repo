//Program to remove duplicate Elements from an Array.

package com.codingraja.array;

import java.util.Scanner;

 class ArrayRemoveDuplicate {

	public static void main(String args[]) {
		
		int num;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num+1];
        
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++)
        {
            array[i] = s.nextInt();
        }
        
		
        for(int i=0; i<num; i++)
        {
            for(int j=i+1; j<num; j++)
            {
                if(array[i] == array[j])
                {
                    for(int k=j; k<num; k++)
                        array[k] = array[k+1];
                    num-=1;
                    j--;
                }
            }
        }
     
        System.out.println("Array with unique Elements : ");
        for(int i=0 ; i<num; i++)
            System.out.print(array[i] + " ");
        

	}

}
