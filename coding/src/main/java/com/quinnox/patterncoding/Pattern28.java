package com.quinnox.patterncoding;

public class Pattern28 {

	public static void main(String[] args) {
		
			int size=5;
			for(int i=0;i<size;i++){
				for(int j=size-1;j>i;j--){
					System.out.print(" ");
				}
				for(int k=0;k<=i;k++){
					System.out.print((char)(k+65));
				}
				System.out.println();
			}

	}

}
