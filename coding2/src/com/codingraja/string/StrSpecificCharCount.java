 /*Program to Accept a String and a Character 
 and find out whether this character present in the string or not. If Present then display how many times this Character occurs.*/

package com.codingraja.string;

import java.util.Scanner;

public class StrSpecificCharCount {

	public static void main(String[] args) {
		
		String str = "";
		char character = '\0';  
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your String : ");
		str = s.nextLine();
		
		System.out.println("Enter the character you want to count : ");
		character = s.next().charAt(0);
	    
	    int i=0 , count=0;
	    
		while(i<str.length()){
			
			if(str.charAt(i) == character){
				
				count++;
				i++;
			}
			else
				i++;
		}
		
		if(count != 0)
			System.out.println( "This character is present and the Frequency of the character is  : " + count);
		else
			System.out.println("The character is not present inside String");
		
		s.close();
	}

}
