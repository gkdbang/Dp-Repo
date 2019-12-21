package com.sgs.collection;

import java.util.Scanner;

public class StringReverseAtItsOwnPosition {

	public static void main(String[] args) {
		
		// Taking String value from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String : ");
		String str = sc.nextLine();
		
		String finalStr = "";
		
		String[] splitstr = str.split(" ");  //Splits the string based on whitespace
		
	//Using java forEach loop iterate elements of string array & append them inside sb followed by reverse
		for(String str2:splitstr){
			StringBuffer sb = new StringBuffer();
			sb.append(str2);
			sb.reverse();
			finalStr += sb.append(" ").toString();
			//finalStr += sb.toString()+" ";
			//finalStr += sb.append(str2).reverse().append(" ").toString();
			//finalStr += sb.append(str2).reverse().toString()+" ";
		}
		System.out.println(finalStr);
	}

}
