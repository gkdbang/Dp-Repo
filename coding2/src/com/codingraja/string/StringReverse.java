/*Accept a string and display it in reverse order. */

package com.codingraja.string;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		
		String originalOne="";
		String reverseOne="";
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String You want to reverse : ");
		originalOne = s.nextLine();
		
		for(int i = originalOne.length()-1; i>=0; i--){
			
			reverseOne = reverseOne + originalOne.charAt(i);
		}
		
		System.out.println("Your reverse string is: " + reverseOne);
        s.close();
	}

}
