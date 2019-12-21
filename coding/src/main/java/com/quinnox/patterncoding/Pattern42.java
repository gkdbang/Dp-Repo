package com.quinnox.patterncoding;

public class Pattern42 {

	public static void main(String[] args) {
		
		int hieght=5;
		int maxAlphabet=1;
		for(int i=1;i<=hieght;i++){
			for(int j=hieght;j>i;j--){
				System.out.print(" ");
			}
			for(char k=(char)(maxAlphabet+64);k>=65;k--){
				System.out.print(k);
			}
			maxAlphabet+=2;
			System.out.println();
		}
		
	}

}
