package com.quinnox.patterncoding;

public class Pattern35 {

	public static void main(String[] args) {
		
		int hieght=5;
		int maxDigit=1;
		for(int i=1;i<=hieght;i++){
			for(int j=hieght;j>i;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=maxDigit;k++){
				System.out.print(i);
			}
			maxDigit+=2;
			System.out.println();
		}
	}

}
