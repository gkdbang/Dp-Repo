package com.codingraja.sorting;

import java.util.Scanner;

public class SelectionSort {

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
        
        // Give a call to selectionSort method
        int[] sortedArray = SelectionSort.doSelectionSort(unSortedArray);
        // Iterate out sortedArray
        System.out.println("Our Sorted Array is : ");
        for(int i=0;i<=sortedArray.length-1;i++){
        	System.out.print(sortedArray[i]);
        	System.out.print(",");
        }
        sc.close();
	}
	
	public static int[] doSelectionSort(int[] arr){
		
		for(int i=0; i<arr.length-1;i++){
			int currentMin=i; //we will assume that element at 0th index (first position) is minimum
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[currentMin]){
					currentMin=j;
				}
			}
			if(currentMin!=i){
				int temp=arr[i];
				arr[i]=arr[currentMin];
				arr[currentMin]=temp;
			}
		}
		return arr;
	}

}
