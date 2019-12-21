package com.quinnox.patterncoding;

public class Pattern33 {

	public static void main(String[] args) {
		
		int size=5;
		for(int i=size;i>=1;i--){
			for(int j=size;j>i;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++){
				System.out.print((char)(k+64));
			}
			System.out.println();
		}

	}

}
