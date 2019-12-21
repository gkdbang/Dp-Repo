package com.codingraja.array;

import java.util.Scanner;

 class ArraySecondMin {

	public static void main(String[] args) {
		
		
		int num, min, sMin;
		
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i < num; i++){
            array[i] = s.nextInt();
        }
        
        
        min = array[0];
        sMin = array[1];
        
        // Logic for min and second min
        for(int i=1;i<num;i++){
        	if(min>array[i]){
                sMin = min;
                min = array[i];
            }
            else if(sMin>array[i])
                sMin = array[i];
        }
        System.out.println("Min element in array: "+min);
        System.out.println("Second Min element in array: "+sMin);
		s.close();
	}

}
