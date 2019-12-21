package com.codingraja.logical;

import java.util.Scanner;

public class CountCharacterInString {

	public static void main(String[] args) {
		
		int count=0;
		String str="";
		System.out.println("Enter the String : ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		// Logic
		for(int i=0;i<str.length();i++){
			count++;
		}
		System.out.println("The given String Consists "+count+" Character");
		sc.close();
	}
}
