package com.sgs.collection;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		
		// Taking String value from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String : ");
		String str = sc.nextLine();
		
		// Creating StringBuffer object
		StringBuffer sb = new StringBuffer(str);
		// Reversing the String
		sb.reverse();
		System.out.println("Reverse of String is : "+sb);
	}
}
