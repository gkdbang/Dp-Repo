/*Program to Accept a String and display no of each Vowel*/

package com.codingraja.string;

import java.util.Scanner;

public class StringDisplayEachVowels {

	public static void main(String[] args) {
		
		int  A_count=0, E_count=0, I_count=0, O_count=0, U_count=0;
		String str = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your String : ");
		str = s.nextLine();
		
		for(int i=0; i<str.length(); i++){
			
			char temp = str.charAt(i);
			
			if((temp == 'A')||(temp == 'a'))
				A_count++;
			
			if((temp == 'E')||(temp == 'e'))
				E_count++;
			
			if((temp == 'I')||(temp == 'i'))
				I_count++;
			
			if((temp == 'O')||(temp == 'o'))
				O_count++;
			
			if((temp == 'U')||(temp == 'u'))
				U_count++;
			
		}
		
		if(A_count>0)
		    System.out.println("no of A's are : " +  A_count);
	    if(E_count>0)
	    	System.out.println("no of E's are : " +  E_count);
	    if(I_count>0)
	    	System.out.println("no of I's are : " +  I_count);
	    if(O_count>0)
	    	System.out.println("no of O's are : " +  O_count);
	    if(U_count>0)
	    	System.out.println("no of U's are : " +  U_count);
		
		s.close();

	}

}
