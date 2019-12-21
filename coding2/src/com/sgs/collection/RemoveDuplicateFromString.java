package com.sgs.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateFromString {
		
	public static void main(String[] args) {
		
		String str = "This is my Country and This is my City";
		List<String> list = new ArrayList<String>();
		Set<String> set = new LinkedHashSet<String>();
		// Split this String based on whitespace
		String[]  splitStr = str.split("\\s");
		for(String newStr:splitStr){
			list.add(newStr);
			set.add(newStr); // Adding splited part one by one into set
		}
		System.out.println("With Duplicate : "+list);
		System.out.println("Removed Duplicate : "+set);
	}
}
