package com.quinnox.patterncoding;

public class Pattern54 {

	public static void main(String[] args) {
		
		int size=4;
		for(int i=1;i<=size;i++){
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<=(size-1);i++){
			for(int j=(size-1);j>=i;j--){
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
