/*Accept 2 strings and check whether all Characters from 1st string are present 2nd String or not.*/

package com.codingraja.string;

import java.util.Scanner;

public class StrCheckOneStringIntoAnother {

	public static void main(String[] args) {
		
		String str1 = "";
		String str2 = ""; 
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your First String : ");
		str1 = s.nextLine();
		
		System.out.println("Enter your Second String : ");
		str2 = s.nextLine();
		
		/*boolean check = str1.contains(str2);
		
		if(check == false)
			System.out.println("String2 are not present in String1");
		else
			System.out.println("String2 are  present in String1");*/
		
		int i=0 , j=0;
		
		while(j<str2.length()){
				
				while(i<str1.length()){
					
					if(str2.charAt(j) == str1.charAt(i)){
						
						break;
					}
					else
						i++;
				}
				
				if(i == str1.length()){
					
					System.out.println("All character of String2 are not present in String1");
					break;
				}
				else
					j++;	              
		}
		
		if(j == str2.length())
				
			System.out.println("All character of String2 are  present in String1");
		
		s.close();
	}

}
