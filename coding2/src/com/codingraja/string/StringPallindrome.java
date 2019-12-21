package com.codingraja.string;

import java.util.Scanner;

public class StringPallindrome {

	public static void main(String[] args) {
		
		String originalString = "";
		String reverseString = "";
		
		System.out.println("Enter the String you want to check : ");
		Scanner sc = new Scanner(System.in);
		originalString = sc.nextLine();
		
		for(int i = originalString.length()-1; i>=0; i--){
			reverseString+=originalString.charAt(i);
		}
		
		if(reverseString.equals(originalString))
			System.out.println("String is Pallindrome : ");
		else
			System.out.println("String is not Pallindrome : ");
		sc.close();
	}

}
