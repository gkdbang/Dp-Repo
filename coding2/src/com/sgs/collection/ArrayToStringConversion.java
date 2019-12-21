package com.sgs.collection;

import java.util.Arrays;

public class ArrayToStringConversion {
		
	public static void main(String[] args) {
		
		String str = "gaurav";
		System.out.println("Printing String : "+str);
		// String to charArray
		char[] chArray = str.toCharArray();
		// Iterate it
		System.out.println("Printing char Array :");
		for(char ch:chArray){
			System.out.println(ch);
		}
		// Now charArray to String
		System.out.println("String representation of an char array : "+Arrays.toString(chArray));
		
		// int[] to String type
		int[] arrays = {222,444,555};
		// String Representation of an array
		System.out.println("String representation of an int array : "+Arrays.toString(arrays));
		// We can convert any primitive array to String type
	}
}
