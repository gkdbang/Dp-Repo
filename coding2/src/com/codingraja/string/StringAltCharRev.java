/*Program to Accept a String and display its alternate characters in reverse*/

package com.codingraja.string;

import java.util.Scanner;

public class StringAltCharRev {

	public static void main(String[] args) {
		
		String str1="";
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your String : ");
		str1 = s.nextLine();
		strReverse(str1);
		s.close();
	}
    
	public static void strReverse(String str1){
		
		String str2="";
		
		for(int i = str1.length()-1; i>=0; i--){
			
			str2 = str2 + str1.charAt(i);
		}
		
		strAlternate(str2);
		
	}

	public static void strAlternate(String str2) {
		
		String str3="";
		
		for(int i=0; i<str2.length(); i++){
			
			if(i%2 == 0){
				
				str3 += str2.charAt(i);
				}
		}
		
		System.out.println("Alternate character of a string is : " + str3);
		
	}
	
}
