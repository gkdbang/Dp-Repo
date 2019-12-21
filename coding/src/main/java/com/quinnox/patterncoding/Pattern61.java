package com.quinnox.patterncoding;

public class Pattern61 {

	public static void main(String[] args) {
		
		int size=4;
		for(int i=size;i>=1;i--){
			for(int j=1;j<i;j++){
				System.out.print(" ");
			}
			for(int k=(i-1);k<size;k++){
				System.out.print(k);
			}
			System.out.println();
		}
		for(int i=1;i<=size;i++){
			for(int j=1;j<=i;j++){
				System.out.print(" ");
			}
			for(int k=i;k<=size-1;k++){
				System.out.print(k);
			}
			System.out.println();
		}

	}

}
