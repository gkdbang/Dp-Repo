/*Program to Accept 2 strings and display the largest string*/


package com.codingraja.string;

import java.util.Scanner;

public class StringCompare {

	public static void main(String[] args) {
		
		String str1 = "" , str2 = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first string : ");
        str1 = s.nextLine();
        System.out.println("Enter second string : ");
        str2 = s.nextLine();
        
        int length1 = compareLength(str1);
        int length2 = compareLength(str2);
        
        if(length1==length2){
        	System.out.println("Both Strings are equal");
        }
        else if(length1 > length2){
        	System.out.println("String1 is larger than String2 : " + str1);
        }
        else
        	System.out.println("String2 is larger than String1 : " + str2);
        
        s.close();
	}

	public static int compareLength(String str) {
		
		int length=0;
		
		for(int i =0; i<str.length(); i++){
			
			length++;
			
		}
		return length;
	}

}
