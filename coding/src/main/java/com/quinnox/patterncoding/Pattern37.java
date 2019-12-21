package com.quinnox.patterncoding;

public class Pattern37 {

	public static void main(String[] args) {
		
		int hieght=5;
		int maxAlphabet=1;
		for(int i=1;i<=hieght;i++){
			for(int j=hieght;j>i;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=maxAlphabet;k++){
				System.out.print((char)(i+64));
			}
			maxAlphabet+=2;
			System.out.println();
		}

	}

}
