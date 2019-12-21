/*Program to Accept a String and display no. of vowels*/

package com.codingraja.string;

import java.util.Scanner;

public class StringCountVowels {

	public static void main(String[] args) {
		
		String str = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your String : ");
		str = s.nextLine();
		
		int count = 0;
		for(int i=0; i<str.length(); i++){
			
	        if((str.charAt(i) == 'a')||(str.charAt(i) == 'e')||(str.charAt(i) == 'i')||(str.charAt(i) == 'o')||(str.charAt(i) == 'u')||(str.charAt(i) == 'A')||(str.charAt(i) == 'E')||(str.charAt(i) == 'I')||(str.charAt(i) == 'O')||(str.charAt(i) == 'U'))
	        {
	           count++;
	        }
			
		}
		
		System.out.println("Total no of vowels are : " + count);
		s.close();
	}

}
