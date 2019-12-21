package com.quinnox.patterncoding;

public class Pattern44 {

	public static void main(String[] args) {
		
		int hieght=5;
		int maxAlpha=1;
		int l=1;
		
		for(int i=1;i<=hieght;i++){
			for(int j=hieght;j>i;j--){
				System.out.print(" ");
			}
			for(char k=1;k<=maxAlpha;k++){
				System.out.print((char)(Math.abs(k-l)+65));
			}
			l++;
			maxAlpha+=2;
			System.out.println();
		}

	}

}
