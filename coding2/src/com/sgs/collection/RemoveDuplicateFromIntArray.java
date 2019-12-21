package com.sgs.collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateFromIntArray {

	public static void main(String[] args) {
		
		// Remove Duplicate from primitive int[] array & Wrapper Integer[] array
		int[] number = {5,1,10,2,1,5,4,4,9,20,8,7,9,7};
		
		Integer[] number2 = {10,40,50,30,50,40,70,90,80,90};
		
		// Add this int[] array into Set
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(int i : number){
			set.add(i);
		}
		System.out.println("Removed Duplicate From Primitive int[] array : "+set);
		System.out.println("========================================================");
		
		// Add this Integer[] array into Set
		Set<Integer> set2 = new LinkedHashSet<Integer>();
		for(Integer i : number2){
			set2.add(i);
		}
		System.out.println("Removed Duplicate From Wrapper Integer[] array : "+set2);
	}
}
