/*Program to Accept a String and display its substring*/

package com.codingraja.string;

import java.util.Scanner;

public class FindSubStringDemo {

	public static void main(String[] args) {
		
		String str1="" , str2=""; 
		int startIndex=0, endIndex=0;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your String : ");
	    str1 = s.nextLine();
	    
		System.out.println("Enter the start position of the substring : ");
		startIndex = s.nextInt();
		
		System.out.println("Enter the number of character of the substring : ");
		endIndex = s.nextInt();
		
		/*str2 = str1.substring(startIndex, endIndex);*/
		
		int i = startIndex;
		while(i<(startIndex+endIndex)){
			
			str2 += str1.charAt(i);
			i++;
		}
		
		System.out.println("Your SubString is : " + str2);
		s.close();
	}

}
