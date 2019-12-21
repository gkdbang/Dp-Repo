/*Accept 2 strings and check whether all Characters from 1st string are present 2nd String or not.*/

package com.codingraja.string;

import java.util.Scanner;

public class CopyOfStrCheckOneStringIntoAnother2 {

	public static void main(String[] args) {
		
		String str1 = "";
		String str2 = ""; 
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your First String : ");
		str1 = s.nextLine();
		
		System.out.println("Enter your Second String : ");
		str2 = s.nextLine();
		
		
		int j=0;
		
		for(int i=0; i<str1.length(); i++){
			
			j=0;
			while(j<str2.length()){
				
				if(str1.charAt(i) == str2.charAt(j)){
					j++;
					i++;
				}
				else
					break;
			}
			
			if(j == str2.length()){
				
				System.out.println("String2 are present inside String1");
				break;
			}
				
		}
		
		if(j<str2.length()){
			
			System.out.println("String2 are not present inside String1");
		}
		
		s.close();
	}

}
