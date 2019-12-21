/*Accept 2 strings and check whether all Characters from 2nd string are present in 1st String*/

package com.codingraja.string;

import java.util.Scanner;

public class StringDemo14 {

	public static void main(String[] args) {
		
		String str1="" , str2="" , finalStr="";
		
		int startIndex1=0, endIndex1=0 , startIndex2=0, endIndex2=0;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter First String : ");
	    str1 = s.nextLine();
	    
	    System.out.println("Enter second String : ");
	    str2 = s.nextLine();
	    
	    
		System.out.println("Enter the start index of  1stsubstring : ");
		startIndex1 = s.nextInt();
		
		System.out.println("Enter the number of character of the 1stsubstring : ");
		endIndex1 = s.nextInt();
		
		System.out.println("Enter the start index of  2ndsubstring : ");
		startIndex2 = s.nextInt();
		
		System.out.println("Enter the number of character of the 2ndsubstring : ");
		endIndex2 = s.nextInt();
		
		
		for(int i=startIndex1; i<(startIndex1+endIndex1); i++)
			finalStr += str1.charAt(i);
		
		for(int i=startIndex2; i<(startIndex2+endIndex2); i++)
			finalStr += str2.charAt(i);
		
		
		System.out.println("After Combined : " + finalStr);	
		
      s.close();
	}

}
