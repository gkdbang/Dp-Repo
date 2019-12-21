/*Program to Accept a String and a character and find out whether this character present in the string*/

package com.codingraja.string;

import java.util.Scanner;

public class StrSearchChar {

	public static void main(String[] args) {
		
		String str = "";
		char search = '\0';      /* Or else we can give char search = '\u0000'; to initialize character.*/
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your String : ");
		str = s.nextLine();
		
		System.out.println("Enter the character you want to search : ");
	    search = s.next().charAt(0);
		
		int i = 0, flag=0;
		
		while(i<str.length()){
			
			if((str.charAt(i)) == search){
				
				flag = 1;
				break;	
			}
			else
				 i++;
		}
		
		if(flag == 1)
			System.out.println("This character is present inside the String.");
		else
			System.out.println("This character is not present inside the String.");
		
		s.close();
	}

}
