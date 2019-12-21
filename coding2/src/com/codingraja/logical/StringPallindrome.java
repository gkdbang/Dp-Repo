package com.codingraja.logical;

import java.util.Scanner;

public class StringPallindrome {

	public static void main(String[] args) {
		
		String originalString = "";
		String reverseString = "";
		
		System.out.println("Enter the String you want to check : ");
		Scanner sc = new Scanner(System.in);
		originalString = sc.nextLine();
		
		// Convert to StringBuffer and apply reverse() method.
		StringBuffer sb = new StringBuffer(originalString);
		reverseString = sb.reverse().toString();
		
		if(reverseString.equals(originalString))
			System.out.println("String is Pallindrome : ");
		else
			System.out.println("String is not Pallindrome : ");
		sc.close();
	}

}
