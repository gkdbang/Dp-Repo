package com.quinnox.patterncoding;

public class Pattern74 {

	public static void main(String[] args) {
		
		int height=5;
		for(int i=height;i>=1;i--){
			for(int j=height;j>i;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++){
				System.out.print((char)(k+64)+" ");
			}
			System.out.print("\n");
		}

	}

}
