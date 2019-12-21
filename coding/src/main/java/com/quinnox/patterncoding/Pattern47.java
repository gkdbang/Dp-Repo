package com.quinnox.patterncoding;

public class Pattern47 {

	public static void main(String[] args) {
		
		int hieght=4;
		int maxStar=7;
		for(int i=hieght;i>0;i--){
			for(int j=hieght;j>i;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=maxStar;k++){
				System.out.print("*");
			}
			maxStar-=2;
			System.out.println();
		}

	}

}
