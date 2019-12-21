package com.codingraja.array;

import java.util.Scanner;

 class ArrayMin {

	public static void main(String[] args) {
		
		int num;
		
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i = 0;i<num;i++){
            array[i] = s.nextInt();
        }
        
        int min = array[0];
        // Logic to find min
        for(int i=1;i<num;i++){
            if(min>array[i]){
                min=array[i];
            }
        }
        System.out.println("Min element in array:"+min);
        s.close();
	}

}
