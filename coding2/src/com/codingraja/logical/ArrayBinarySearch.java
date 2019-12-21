package com.codingraja.logical;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayBinarySearch {

	public static void main(String[] args) {
		
		int num=0;
		int item=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of Element in Array : ");
		num = sc.nextInt();
		int[] array = new int[num];
		
		System.out.println("Now Enter the elements of Array : ");
		for(int i=0;i<array.length;i++){
			array[i]=sc.nextInt();
		}
		
		System.out.println("Enter Item to be searched : ");
		item = sc.nextInt();
		
		int index = Arrays.binarySearch(array, item);  // it returns index
		System.out.println("Item found at index : "+index);
		sc.close();
	}
}
