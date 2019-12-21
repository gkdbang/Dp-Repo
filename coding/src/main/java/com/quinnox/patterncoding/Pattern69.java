package com.quinnox.patterncoding;

public class Pattern69 {

	public static void main(String[] args) {
		
		int height=5;
		for(int i=height;i>=1;i--){
			for(int j=height;j>i;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++){
				System.out.print("* ");
			}
			System.out.print("\n");
		}

	}

}
