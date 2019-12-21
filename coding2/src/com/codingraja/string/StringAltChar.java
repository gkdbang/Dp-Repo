/* Program to Accept a String and display its alternate characters*/

package com.codingraja.string;

import java.util.Scanner;

public class StringAltChar {

	public static void main(String[] args) {
		
		String str1="", str2="";
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your String : ");
	    str1 = s.nextLine();
	    str2="";
	
		for(int i=0; i<str1.length(); i++){
			
			if(i%2 == 0){
				
				str2 += str1.charAt(i);
				}
		}
		
		System.out.println("Alternate character of a string is : " + str2);
		s.close();
	}	

}
