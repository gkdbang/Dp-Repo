package com.codingraja.sorting;

import java.util.Scanner;

public class InsertionSort {

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
        
        // Give a call to diInsertionSort method
        int[] sortedArray=InsertionSort.doInsertionSort(unSortedArray);
        
        System.out.println("Our Sorted Array is : ");
        // Iterate our sortedArray
        for(int i:sortedArray){
        	System.out.println(i);
        }
        sc.close();
	}
	public static int[] doInsertionSort(int[] arr){
		
		int temp=0,length=arr.length;
		// Assume that element at 0th index is in sorted portion
		for(int i=1;i<=length-1;i++){
			while(i>0 && arr[i-1]>arr[i]){
				temp=arr[i-1];
				arr[i-1]=arr[i];
				arr[i]=temp;
				i--;
			}
		}
		return arr;
	}
	
}
