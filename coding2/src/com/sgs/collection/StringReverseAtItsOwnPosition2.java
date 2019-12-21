package com.sgs.collection;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringReverseAtItsOwnPosition2 {

	public static void main(String[] args) {
		
		// Taking String value from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String : ");
		String str = sc.nextLine();
		
		String finalStr = "";
		
		// After Getting String from user Tokenize it
		StringTokenizer st = new StringTokenizer(str," "); //Tokenize the string based on whitespace
		while(st.hasMoreTokens()){
			String token = st.nextToken(); // Getting token one by one
			StringBuffer sb = new StringBuffer();
			finalStr =finalStr+sb.append(token).reverse().toString()+" ";
		}
			System.out.println(finalStr);
	}

}
