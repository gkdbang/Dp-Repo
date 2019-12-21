package com.codingraja.array;

import java.util.Scanner;

 class ArrayLinearSearch {

	public static void main(String[] args) {
		
		int num, item, flag=0;
		
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++){
            array[i] = s.nextInt();
        }
        
        System.out.println("Enter Item for Searching :");
        item = s.nextInt();
        
        // Logic For Searching
        for(int i=0; i<array.length; i++){
            if(item==array[i]){   //compare item with array elements
            	System.out.println("Item Found at index : "+i+" And At Location : " + (i+1));
                flag++;  //if item is found, flag will be changed
            }
        }
        if(flag == 0)  //if item is not found, flag will not change
        	System.out.println("Item is not found in Array");
        s.close();
	}

}
