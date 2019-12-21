package com.sgs.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CollectionBinarySearch {

	public static void main(String[] args) {
		
		int num=0;
		int item=0;
		List ls = new ArrayList();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in collection : ");
		num = sc.nextInt();
		
		System.out.println("Enter Collection Elements : ");
		for(int i=0;i<num;i++){
			ls.add(sc.nextInt());
		}
		
		System.out.println("Enter the Element want to be searched : ");
		item = sc.nextInt();
		
		// use search method
		int index = Collections.binarySearch(ls, item); // It returns index
		System.out.println("Item found at index : "+index);
		sc.close();
	}
}
