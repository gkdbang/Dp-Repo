package com.codingraja.sorting;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		int num=0;
		
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = sc.nextInt();
        int unSortedArray[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i=0; i<num; i++){
        	unSortedArray[i] = sc.nextInt();
        }
        
        // Give a call to doBubbleSort method
        int[] sortedArray=BubbleSort.doBubbleSort(unSortedArray);
        
        System.out.println("Our Sorted Array is : ");
        // Iterate Our sorted Array
        for(int i:sortedArray){
        	System.out.print(i);
        	System.out.print(",");
        }
        sc.close();
	}
	
	public static int[] doBubbleSort(int[] arr){
		
		// Logic for bubble Sort to sort in Ascending order 
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}

}
