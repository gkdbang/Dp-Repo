package com.sgs.interview.logical;

import java.util.Scanner;

public class HexaOfA_To_Z {

	public static void main(String[] args) {
		
		char ch1,ch2;
		int ascii_ch1,ascii_ch2;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the initial Alphabet : ");
		ch1=sc.next().charAt(0);
		
		ascii_ch1=(int)ch1;
		System.out.print("Enter the last Alphabet : ");
		ch2=sc.next().charAt(0);
		ascii_ch2=(int)ch2;
		
		for(int i=ascii_ch1;i<=ascii_ch2;i++){
			toHexaDecimal(i);
		}
		sc.close();
	}
	
	public static void toHexaDecimal(int number){
		// logic to convert Decimal(Base 10) to HexaDecimal(Base 16)
		int count=0;
		int reminder;
		int[] arr=new int[26];
		while(number>0){
			reminder=number%16;
			if(reminder<10)
				arr[count]=reminder;
			else{
				arr[count]=55+reminder;
			}
			number/=16;
			count++;
		}
		for(int j=count-1;j>=0;j--){
			if(arr[j]>9)
				System.out.print((char)arr[j]);
			else
				System.out.print(arr[j]);
		}
	}
}
