package com.codingraja.array;

import java.util.Scanner;

 class ArraySecondMax {

	public static void main(String[] args) {
		
		
		int i,num, max, sMax;
		
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(i = 0;i<array.length;i++){
            array[i]=s.nextInt();
        }
        
        max = array[0];
        sMax = array[1];
        // Logic for max and secondMax
        for(i=1;i<array.length;i++){
        	if(max<array[i]){
                sMax = max;
                max = array[i];
            }
            else if(sMax<array[i])
                sMax = array[i];
        }
        System.out.println("Max element in Array : "+max);
        System.out.println("Second Max element in Array : "+sMax);
		s.close();
	}

}
