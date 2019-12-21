package com.codingraja.logical;

import java.util.Scanner;

public class CountCharFrequencyInString {

	public static void main(String[] args) {
		
		String str=null;
		int count=0;
		System.out.println("Enter the String : ");
		Scanner sc = new Scanner(System.in);
		str=sc.nextLine();
		//Change into charArray
		char[] ch=str.toCharArray();
		// Logic
		for(int i=0;i<ch.length;i++){
			count=1;
			for(int j=i+1;j<ch.length;j++){
				if(ch[i]==ch[j]&&ch[i]!='\0'){
					count++;
					ch[j]='\0';
				}
			}
			if(ch[i]!='\0')
				System.out.println(ch[i]+" is present "+count+" times");
		}
		sc.close();
	}
}
