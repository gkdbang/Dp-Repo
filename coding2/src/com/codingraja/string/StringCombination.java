/*Program to Accept 2 strings and display combination of two strings*/

package com.codingraja.string;

import java.util.Scanner;

public class StringCombination {

	public static void main(String[] args) {
		
		String str1 = "" , str2 = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first string : ");
        str1 = s.nextLine();
        System.out.println("Enter second string : ");
        str2 = s.nextLine();
        
        String finlString="";
        
        // 1st Approach is use concat() method of Strong class
       // finlString = str1.concat(" ").concat(str2);
        
        // 2nd Approach is convert String into StrinBuffer and then use append() method
       /* StringBuffer sb1 = new StringBuffer(str1);
        StringBuffer sb2 = new StringBuffer(str2);
        finlString = sb1.append(" ").append(sb2).toString();*/
        
        // 3rd Approach our own logic
        // First Add str1 into finlString 
		for(int i=0; i<str1.length(); i++){
			finlString+=str1.charAt(i);
		}
		// And add space between two string
		finlString=finlString.concat(" ");
		
		// Finally add str2 into finalString
		for(int i=0;i<str2.length();i++){
			finlString=finlString+str2.charAt(i);
		}
		
		System.out.println("After Combined : " + finlString);	
       
        s.close();
	}

}
