package com.codingraja.logical;

import java.util.Scanner;

public class PrintUniqueCharFormString2 {

	public static void main(String[] args) {
		
		String str = null;
		int count=0;
		System.out.println("Enter the Stirng : ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		// Logic
		for(int i=0;i<str.length();i++){
			count=1;
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(i)==str.charAt(j)&&str.charAt(i)!='\0'){
					count++;
					str=str.replace(str.charAt(j),'\0');
				}
			}
			if(count==1&&str.charAt(i)!='\0')
				System.out.println("This Character "+str.charAt(i)+" is present only "+count+
						" time is unique.");
		}
		sc.close();
	}
}
