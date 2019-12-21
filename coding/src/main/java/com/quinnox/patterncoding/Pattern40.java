package com.quinnox.patterncoding;

public class Pattern40 {

	public static void main(String[] args) {
		
		int hieght=5;
		int maxDight=1;
		for(int i=1;i<=hieght;i++){
			for(int j=hieght;j>i;j--){
				System.out.print(" ");
			}
			for(int k=maxDight;k>=1;k--){
				System.out.print(k);
			}
			maxDight+=2;
			System.out.println();
		}

	}

}
