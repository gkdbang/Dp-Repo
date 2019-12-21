package com.quinnox.patterncoding;

public class Pattern34 {

	public static void main(String[] args) {
		
		int hieght=5;
		int maxStar=1;
		for(int i=1;i<=hieght;i++){
			for(int j=hieght;j>i;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=maxStar;k++){
				System.out.print("*");
			}
			maxStar+=2;
			System.out.println();
		}

	}

}
