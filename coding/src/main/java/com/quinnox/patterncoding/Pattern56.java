package com.quinnox.patterncoding;

public class Pattern56 {

	public static void main(String[] args) {
		
		int size=4;
		for(int i=size;i>=1;i--){
			for(int j=i;j<=size;j++){
				System.out.print((j-1));
			}
			System.out.println();
		}
		for(int i=1;i<=(size-1);i++){
			for(int j=i;j<=(size-1);j++){
				System.out.print(j);
			}
			System.out.println();
		}

	}

}
