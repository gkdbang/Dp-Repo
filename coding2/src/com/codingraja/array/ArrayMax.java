package com.codingraja.array;

import java.util.Scanner;

 class ArrayMax {

	public static void main(String[] args) {
		
		int num;
		
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = sc.nextInt();
        int array[] = new int[num];
        
        // Entering Array Element one by one
        System.out.println("Enter elements of array:");
        for(int i = 0; i<array.length; i++){
            array[i] = sc.nextInt();
        }
        
        int max=array[0];
        // Logic to find Max
        for(int i=1;i<array.length;i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        System.out.println("Max element in array:"+max);
		sc.close();
	}

}
