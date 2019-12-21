package com.codingraja.string;

import java.util.Scanner;

public class StringDemo15 {

	public static void main(String[] args) {
		
		
		String str1="", str2="";
		
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string : ");
        str1 = s.nextLine();
        
		 for (int i=0; i < str1.length(); i++){
			 
	                str2 += str1.charAt(i); 
	        }
		 
		 System.out.println("After copied : " + str2);
		 s.close();
	}

}
