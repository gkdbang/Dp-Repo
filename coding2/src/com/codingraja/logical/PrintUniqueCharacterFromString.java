package com.codingraja.logical;

import java.util.Scanner;

public class PrintUniqueCharacterFromString {

	public static void main(String[] args) {
		
		String str = null;
		int count=0;
		System.out.println("Enter the Stirng : ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		// Change String to charArray
		char[] ch = str.toCharArray();
		// Logic
		for(int i=0;i<ch.length;i++){
			count=1;
			for(int j=i+1;j<ch.length;j++){
				if(ch[i]==ch[j]&&ch[i]!='\0'){
					count++;
					ch[j]='\0';
				}
			}
			if(count==1&&ch[i]!='\0')
				System.out.println("This Character "+ch[i]+" is present only "+count+
						" time is unique.");
		}
		sc.close();
	}
}
